package softpudding;

import java.util.concurrent.atomic.AtomicLong;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class OAuthController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${clientid}")
    String clientid = "";
    @Value("${clientsecret}")
    String clientsecret = "";
    @Value("${url}")
    String url = "";
    /* 测试docker compose 时用的认证信息
    String url = "https://github.com/login/oauth/access_token";
    String clientid = "457db76ba9bac22b103a";
    String clientsecret = "4378d356261f59a7098159301b11b6d49d3a44ba";
    */
    @HystrixCommand(fallbackMethod = "oAuthCallBackFallback", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="15000")
    })
    @RequestMapping("/oauthcallback")
    void oAuthCallBack (@RequestParam(value = "code")String code,
                        HttpServletRequest request, HttpServletResponse response) throws Exception{
        User u = new User(code);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
        map.add("client_id",clientid);
        map.add("client_secret",clientsecret);
        map.add("code",u.getCode());
        ResponseEntity<Token> responseEntity = restTemplate.postForEntity(url,map,Token.class);
        Token t = responseEntity.getBody();
        if(t.getAccess_token()!=null){
            //璁よ瘉鎴愬姛浜?
            Cookie cookie = new Cookie("WLTOKEN",t.getAccess_token());
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8080/wordladder");
        }
        else {
            throw new Exception("Failed In OAuth.");
        }
    }

    void oAuthCallBackFallback(String code, HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        System.out.println("OAuthCallBackFallBack: receive code:"+code);
        response.sendRedirect("http://localhost:8080/");
    }

}
