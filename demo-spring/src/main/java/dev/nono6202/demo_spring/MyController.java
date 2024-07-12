package dev.nono6202.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    private accountRep arep;

    @GetMapping("/")
    public String main1(Model mo){
        mo.addAttribute("selector", "Main");
        return "Main";
    }
    @GetMapping("/Main")
    public String main2(Model mo){
        mo.addAttribute("selector", "Main");
        return "Main";
    }

    @GetMapping("/SndYearFst")
    public String SndYearFst(Model mo){
        mo.addAttribute("selector", "SndYearFst");
        return "SndYearFst";
    }
    
    @GetMapping("/etc")
    public String etc(Model mo){
        mo.addAttribute("selector", "etc");
        return "etc";
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
                se.setAttribute("checking", "1");
                return "redirect:/Main";
            }
        }

        re.addAttribute("msg", "넌 모찌나간다");
        re.addAttribute("url","/login");
        return "redirect:/popup";
    }
    
    
}
