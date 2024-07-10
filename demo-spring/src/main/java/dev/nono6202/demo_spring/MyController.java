package dev.nono6202.demo_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {

    @GetMapping("/")
    public String main(){
        return "main.html";
    }


}
