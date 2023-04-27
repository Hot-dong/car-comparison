package comunity.carcomunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        String greeting = (String) session.getAttribute("greeting");

        model.addAttribute("greeting", greeting);
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/join")
    public String join() {
        return "join";
    }
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        String greeting = (String) session.getAttribute("greeting");

        model.addAttribute("greeting", greeting);
        return "dashboard";
    }
}
