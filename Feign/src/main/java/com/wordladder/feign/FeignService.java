package com.wordladder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "wordladder-service",url = "http://localhost:9000",fallback = FeignClientFallback.class)
public interface FeignService {
    @RequestMapping("get_wordladder")
    String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end);

}

@Component
class FeignClientFallback implements FeignService{
    @Override
    public String ladder(String begin,String end){
        return "FeignClientFallback: "+begin+" "+end;
    }
}