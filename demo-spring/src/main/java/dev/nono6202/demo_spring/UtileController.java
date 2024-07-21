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
import dev.nono6202.demo_spring.java.Filehtml;
import dev.nono6202.demo_spring.java.charThing;
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
        return "/basic/popup";
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
                            @RequestParam("link") String link,
                            @RequestParam("tag") String tag,
                            @RequestParam("substance") String substance,
                            RedirectAttributes re) {
        
        if(prep.existsById(link)){ //링크가 동일하면 실패
            re.addAttribute("msg", "동일한 링크가 있습니다.");
            re.addAttribute("url","/post");
        }else if(charThing.annihilating(null, link)){
            re.addAttribute("msg", "특수문자 또는 특정단어가 들어가 있습니다.");
            re.addAttribute("url","/post");
        }else{
            post p = new post();
            p.content= content; p.title= title; p.link= link; 
            p.tag= tag; p.substance = substance;
    
            prep.save(p);
    
            Filehtml.createhtml(null, content+"\\"+link);
            
            re.addAttribute("msg", "대성공");
            re.addAttribute("url","/post");
        }
        return "redirect:/popup";
    }

    @GetMapping("/post/putup2")
    public String postputup2(@RequestParam("appearance") String appearance,
                            @RequestParam("link") String link,
                            RedirectAttributes re) {

        System.out.println(charThing.annihilating(null, link));
        
        if(crep.existsById(link)){ //목차가 동일하면 실패
            re.addAttribute("msg", "동일한 링크가 있습니다.");
            re.addAttribute("url","/post");
        }else if(charThing.annihilating(null, link)){
            re.addAttribute("msg", "특수문자 또는 특정단어가 들어가 있습니다.");
            re.addAttribute("url","/post");
        }else{
            content c = new content();
            c.num= 0; c.appearance= appearance; c.link= link;
            crep.save(c);

            Filehtml.createhtml(null, link);
            re.addAttribute("msg", "대성공");
            re.addAttribute("url","/post");
        }
        return "redirect:/popup";
    }

    @GetMapping("/post/num")
    public String postnum(@RequestParam("num") List<Integer> num,
                            RedirectAttributes re) {
        
        List<String> link = crep.findlink();

        for(int i=0;i<crep.colcount();i++){
            crep.updatenum(num.get(i),link.get(i));
        }
        
        re.addAttribute("msg", "대성공");
        re.addAttribute("url","/post");
        return "redirect:/popup";
    }

    @GetMapping("/post/delete1")
    public String postdelete1(@RequestParam("content") String content,
                            RedirectAttributes re) {

        System.out.println(content);
        if(content.equals("void")){
            re.addAttribute("msg", "선택 해주세요.");
            re.addAttribute("url","/post");
        }else{
            crep.deleteById(content);
            Filehtml.deletehtml(null, content);
            re.addAttribute("msg", "대성공");
            re.addAttribute("url","/post");
        }
        return "redirect:/popup";
    }
    
    @GetMapping("/post/delete2")
    public String postdelete2(@RequestParam("title") String title,
                            RedirectAttributes re) {

        if(title.equals("void")){
            re.addAttribute("msg", "선택 해주세요.");
            re.addAttribute("url","/post");
        }else{
            prep.deleteById(charThing.extract(null,title));
            Filehtml.deletehtml(null, title);
            re.addAttribute("msg", "대성공");
            re.addAttribute("url","/post");
        }
        return "redirect:/popup";
    }
}
