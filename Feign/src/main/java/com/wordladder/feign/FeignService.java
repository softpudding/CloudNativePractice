package com.wordladder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "wordladder-service",url = "http://localhost:9000")
public interface FeignService {
    @RequestMapping("get_wordladder")
    String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end);
}
