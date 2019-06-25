package wordladder;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LadderController {
    @RequestMapping("/get_wordladder")
    @HystrixCommand(fallbackMethod = "ladderFallBack")
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end,HttpServletRequest req) {
        Dict dict = new Dict();
        if(begin.equals("") || end.equals("")){
            return "input wrong";
        }
        else {
            Ladder ladder = new Ladder(begin, end, dict);
            return ladder.getResult()+" 111";
        }
    }
    // hystrix method for ladder
    public String ladderFallBack(String begin,String end,HttpServletRequest req){
        return "WordladderFallback: "+begin+" "+end;
    }

}