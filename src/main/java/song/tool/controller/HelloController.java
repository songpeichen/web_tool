package song.tool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    String hello(){
        if (true)
        throw new RuntimeException();
        return "Hello Spring Boot!111112222111111";
    }

}
