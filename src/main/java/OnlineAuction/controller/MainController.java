package OnlineAuction.controller;

import OnlineAuction.entity.Bet;
import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import OnlineAuction.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AuthorService authorService;
    @Autowired
    UserService userService;
    @Autowired
    PlumbService plumbService;
    @Autowired
    BetService betService;
    @Autowired
    DescribeOfUserService describeOfUserService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("authors", authorService.findAllPageable(new PageRequest(0, 8)));

        return "index";
    }

    @GetMapping("/admin/adminPage")
    public String adminPage(Model model){
        return "adminPage";
    }

    @GetMapping("/userPage{user}")
    public String userPage(@PathVariable("user")String userName, Model model){
        User user = userService.findByName(userName);
        DescribeOfUser describeOfUser = describeOfUserService.findByUser(user);
        Date currentDate = new Date();
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.findPlumbByUser(user, new PageRequest(0, 12)));
        for (Plumb plumb: plumbs) {
            Bet bet = betService.findMaxBet(plumb);
            plumb.setBets(new ArrayList<Bet>());
            plumb.addBet(bet);
        }
        model.addAttribute("user", user);
        model.addAttribute("describeOfUser", describeOfUser);
        model.addAttribute("plumbs", plumbs);
        model.addAttribute("currentDate", currentDate);
        return "userPage";
    }

    @GetMapping("/describeOfUser{user}")
    public String describeOfUserPage(@PathVariable("user")String userName, Model model){
        model.addAttribute("userName", userName);
        return "describeOfUserPage";
    }

    @PostMapping("/asd")
    public String logMe() {
        return "redirect:/";
    }

    @PostMapping("/createDescribeOfUser{user}")
    public String createDescribeOfUser(@PathVariable("user")String userName, @RequestParam String name, @RequestParam String surname, @RequestParam String phone,
                                        @RequestParam String country, @RequestParam String city, @RequestParam int zipCode){
        User user = userService.findByName(userName);
        DescribeOfUser describeOfUser = new DescribeOfUser(user, name, surname, phone, country, city, zipCode);
        describeOfUserService.save(describeOfUser);
        return "redirect:/userPage" + userName;
    }

    @GetMapping("/rules")
    public String goToRules(){
        return "rules";
    }

}
