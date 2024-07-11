package dev.nono6202.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class MyController {

    @GetMapping("/")
    public String main(Model mo){
        mo.addAttribute("selector", "main");
        return "main.html";
    }


}
