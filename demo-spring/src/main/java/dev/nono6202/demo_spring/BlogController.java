package dev.nono6202.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.nono6202.demo_spring.DB.contentRep;
import dev.nono6202.demo_spring.DB.postRep;

@Controller
public class BlogController {

    @Autowired
    private contentRep crep;
    @Autowired
    private postRep prep;
    
    @GetMapping(value={"/","/Main"})
    public String main(Model mo){
        mo.addAttribute("selector", "Main");
        mo.addAttribute("content", crep.findall());
        mo.addAttribute("post", prep.findtitle());
        return "Main";
    }

    @GetMapping("/Main/{list}")
    public String list(@PathVariable String list,Model mo){
        mo.addAttribute("selector", list);
        mo.addAttribute("content", crep.findall());
        mo.addAttribute("post", prep.findpost(list));
        return list;
    }

    @GetMapping("/Main/{contentlist}/{postlist}")
    public String list1(@PathVariable String contentlist,@PathVariable String postlist,Model mo){

        return contentlist+"/"+postlist;
    }


}
