package dev.nono6202.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.nono6202.demo_spring.DB.contentRep;

@Controller
public class BlogController {

    @Autowired
    private contentRep crep;
    
    @GetMapping(value={"/","/Main"})
    public String main(Model mo){
        mo.addAttribute("selector", "Main");
        mo.addAttribute("content", crep.findall());
        return "Main";
    }

    @GetMapping("/Main/{contentlist}")
    public String SndYearFst(@PathVariable String contentlist,Model mo){
        mo.addAttribute("selector", contentlist);
        mo.addAttribute("content", crep.findall());
        return contentlist;
    }
    
}
