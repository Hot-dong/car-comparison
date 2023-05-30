package comunity.carcomunity.controller;

import comunity.carcomunity.domain.Member;
import comunity.carcomunity.entity.User;
import comunity.carcomunity.service.MemberService;
//import comunity.carcomunity.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/join-ok")
    public String join(@ModelAttribute Member member) {
        LoggerFactory.getLogger(getClass()).info("MEMBER {}", member);
        memberService.addMember(member);
        return "redirect:/login";
    }
}
