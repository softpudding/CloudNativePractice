package com.wordladder.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping("/get_wordladder")
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end){
        return feignService.ladder(begin,end);
    }
}