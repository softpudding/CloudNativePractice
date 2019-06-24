# Hystrix
## Overview
我给运算模块(wordladder)、静态文件模块(Feign)、Gateway以及认证模块加了不同的Hystrix实现。
### wordladder
wordladder的hystrix:
```Java
public String ladderFallBack(String begin,String end,HttpServletRequest req){
        return "WordladderFallback: "+begin+" "+end;
    }
```
这个降级方法返回两个查询参数，以及标识FallBack方法的开头字符串。
### Feign
```Java
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
```
这个降级方法基本上是和wordladder的方法是一样的。
### Gateway
把fallback的uri设置成http://localhost:8083/。直接导航到feign的首页。
### OAuth
这个fallback是针对于github的回调函数而言的。
```Java
void oAuthCallBackFallback(String code, HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        System.out.println("OAuthCallBackFallBack: receive code:"+code);
        response.sendRedirect("http://localhost:8080/");
    }
```
降级处理的结果是在控制台打印收到的回调code，并且将浏览器重定位到主页面。