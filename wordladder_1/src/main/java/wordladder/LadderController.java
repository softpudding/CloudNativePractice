package wordladder;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LadderController {

    @RequestMapping("/get_wordladder")
    public String ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end) {
        Dict dict = new Dict();
        if(begin.equals("") || end.equals("")){
            return "input wrong";
        }
        else {
            Ladder ladder = new Ladder(begin, end, dict);
            return ladder.getResult()+" 1";
        }
    }
}