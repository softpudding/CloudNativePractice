package wordladder;


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
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end,HttpServletRequest req) {
        Dict dict = new Dict();
        if(begin.equals("") || end.equals("")){
            return "input wrong";
        }
        else {
            Ladder ladder = new Ladder(begin, end, dict);
            return ladder.getResult();
        }
    }

    @RequestMapping(value="/getToken",method = RequestMethod.POST)
    public void getToken(@RequestParam(value="token") String token,HttpServletRequest request){
        HttpSession session =  request.getSession();
        session.setAttribute("token",token);
        System.out.println(token);
    }

}