package softpudding;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
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
    String clientid = "7dbe5073bd774dfb4817";
    String clientsecret = "41b3421b2e3a96bd1294e3f3df7025b6b0a084bb";
    String url = "https://github.com/login/oauth/access_token";
    String wlurl = "http://localhost:8083/oauthtoken";
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
            response.sendRedirect("http://localhost:8083/wordladder");
        }
        else {
            throw new Exception("Failed In OAuth.");
        }
    }

}
