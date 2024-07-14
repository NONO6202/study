package dev.nono6202.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.nono6202.demo_spring.DB.contentRep;

@Controller
public class BlogController {

    @Autowired
    private contentRep crep;
    
    @GetMapping("/")
    public String main1(Model mo){
        mo.addAttribute("selector", "Main");
        mo.addAttribute("content", crep.findall());
        return "Main";
    }
    @GetMapping("/Main")
    public String main2(Model mo){
        mo.addAttribute("selector", "Main");
        mo.addAttribute("content", crep.findall());
        return "Main";
    }

    @GetMapping("/SndYearFst")
    public String SndYearFst(Model mo){
        mo.addAttribute("selector", "SndYearFst");
        mo.addAttribute("content", crep.findall());
        return "SndYearFst";
    }
    
    @GetMapping("/etc")
    public String etc(Model mo){
        mo.addAttribute("selector", "etc");
        mo.addAttribute("content", crep.findall());
        return "etc";
    }
}
