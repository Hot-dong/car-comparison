package comunity.carcomunity.controller;

import comunity.carcomunity.entity.Car;
import comunity.carcomunity.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("search")
    public String list(Model model,
                       @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                       @RequestParam(value= "search", defaultValue = "") String search) {
//        List<User> userList = userService.getList();
//        Page<User> userList = userService.getPagingList(pageNumber - 1);
        Page<Car> userList = carService.getSearchList(search, (pageNumber - 1));
        model.addAttribute("list", userList);

        return "user/list";
    }

}
