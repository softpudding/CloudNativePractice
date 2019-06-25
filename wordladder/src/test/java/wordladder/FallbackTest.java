package wordladder;

import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FallbackTest {
    LadderController ladderController= new LadderController();

    @Test
    public void testFallBack(){
        assert ladderController.ladderFallBack("dog","cat",null).equals("WordladderFallback: dog cat");
    }
}
