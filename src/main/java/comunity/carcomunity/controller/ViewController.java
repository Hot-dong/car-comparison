package comunity.carcomunity.controller;

import comunity.carcomunity.entity.Car;
import comunity.carcomunity.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");
        model.addAttribute("userName", userName);

        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password are invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("error", "Your username and password are invalid.");
        return "login";
    }

    @RequestMapping("/join")
    public String join() {
        return "join";
    }

    @RequestMapping("/buy")
    public String buy(HttpSession session, Model model,
                      @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                      @RequestParam(value= "search", defaultValue = "") String search) {

        String userName = (String) session.getAttribute("userName");
        model.addAttribute("userName", userName);

        Page<Car> carList = carService.getSearchList(search, (pageNumber-1));
        model.addAttribute("list", carList);

        return "buy";
    }

    @RequestMapping("/detail")
    public String buy(HttpSession session, Model model,
                      @RequestParam(value= "search") String search) {

        String userName = (String) session.getAttribute("userName");
        model.addAttribute("userName", userName);

        Car carList = carService.getCarList(search);
        model.addAttribute("list", carList);

        return "detail";
    }

}
