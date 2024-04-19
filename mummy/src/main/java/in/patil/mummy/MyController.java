package in.patil.mummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {

    @RequestMapping("Navin")
    public static String requestMethodName(){
        
        return new String("this is navin patil");
    }
    
    
    @RequestMapping("m")
    public static String myMethod(){
        
        return "this is navin patil";
    }
}
