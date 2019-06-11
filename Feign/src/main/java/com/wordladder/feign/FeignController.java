package com.wordladder.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.Enumeration;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping("/get_wordladder")
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin, @RequestParam(value="end", defaultValue="data") String end,
                         HttpServletRequest req, HttpServletResponse res) throws Exception{
        Cookie[] cookies = req.getCookies();
        boolean isLogin= false;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("WLTOKEN"))
                isLogin = true;
        }
        if(isLogin)
            return feignService.ladder(begin,end);
        else
        {
            res.sendRedirect("http://localhost:8083/home");
            return "failed.";
        }
    }
}