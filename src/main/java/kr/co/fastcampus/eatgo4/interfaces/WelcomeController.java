package kr.co.fastcampus.eatgo4.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String hello(){
        return "Hellobb";
    }
}
