package dev.nono6202.demo_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.nono6202.demo_spring.DB.accountRep;
import dev.nono6202.demo_spring.DB.content;
import dev.nono6202.demo_spring.DB.contentRep;
import dev.nono6202.demo_spring.DB.post;
import dev.nono6202.demo_spring.DB.postRep;
import jakarta.servlet.http.HttpSession;

@Controller
public class UtileController {

    @Autowired
    private accountRep arep;
    @Autowired
    private contentRep crep;
    @Autowired
    private postRep prep;

    @GetMapping("/Abasic")
    public String Abasic(Model mo){
        mo.addAttribute("selector", "Main");
        mo.addAttribute("content", crep.findall());
        return "Main";
    }

    @GetMapping("/login")
    public String login(Model mo){
        return "login";
    }

    @GetMapping("/popup")
    public String popup(@RequestParam("msg") String msg, 
                            @RequestParam("url") String url, Model mo) {
        mo.addAttribute("msg",msg);
        mo.addAttribute("url",url);                      
        return "popup";
    }

    @GetMapping("/login/check")
    public String loginCheck(@RequestParam("mid") String mid,
                            @RequestParam("mpw") String mpw,
                            HttpSession se, RedirectAttributes re) {
        if(arep.existsById(mid)){
            if(mpw.equals(arep.checkpw(mid))){
                se.setAttribute("checking", "Success");
                return "redirect:/post";
            }
        }

        re.addAttribute("msg", "넌 모찌나간다");
        re.addAttribute("url","/login");
        return "redirect:/popup";
    }
    
    @GetMapping("/post")
    public String post(HttpSession se, Model mo) {
        mo.addAttribute("checking", se.getAttribute("checking"));
        mo.addAttribute("contentarr", crep.findall());
        mo.addAttribute("titles", prep.findtitle());
        return "post";
    }

    @GetMapping("/post/putup1")
    public String postputup1(@RequestParam("content") String content,
                            @RequestParam("title") String title,
                            @RequestParam("tag") String tag,
                            RedirectAttributes re) {
        
        post p = new post();
        p.content= content; p.title= title; p.tag= tag;
        prep.save(p);
        
        re.addAttribute("msg", "대성공");
        re.addAttribute("url","/post");
        return "redirect:/popup";
    }

    @GetMapping("/post/putup2")
    public String postputup2(@RequestParam("appearance") String appearance,
                            @RequestParam("link") String link,
                            RedirectAttributes re) {
        
        content c = new content();
        c.appearance= appearance; c.link= link;
        crep.save(c);

        Filehtml.createhtml(null, link);
        re.addAttribute("msg", "대성공");
        re.addAttribute("url","/post");
        return "redirect:/popup";
    }

    @GetMapping("/post/delete1")
    public String postdelete1(@RequestParam("content") String content,
                            RedirectAttributes re) {

        crep.deleteById(content);
        Filehtml.deletehtml(null, content);
        re.addAttribute("msg", "대성공");
        re.addAttribute("url","/post");
        return "redirect:/popup";
    }
    
    @GetMapping("/post/delete2")
    public String postdelete2(@RequestParam("title") String title,
                            RedirectAttributes re) {

        prep.deleteById(title);
        Filehtml.deletehtml(null, title);
        re.addAttribute("msg", "대성공");
        re.addAttribute("url","/post");
        return "redirect:/popup";
    }
}
