package comunity.carcomunity.controller;

import comunity.carcomunity.entity.User;
import comunity.carcomunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join-ok")
    public String join(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
