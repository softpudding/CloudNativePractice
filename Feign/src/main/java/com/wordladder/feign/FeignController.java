package com.wordladder.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping("/get_wordladder")
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end){
        return feignService.ladder(begin,end);
    }

    @RequestMapping(value="/oauthtoken",method = RequestMethod.POST)
    public String oauthToken(HttpServletRequest request){
        String token = request.getParameter("OAUTH-TOKEN");
        System.out.println(token);
        feignService.getToken(token);
        return token;
    }
}