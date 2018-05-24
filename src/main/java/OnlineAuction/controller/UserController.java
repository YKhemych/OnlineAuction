package OnlineAuction.controller;

import OnlineAuction.entity.Bet;
import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import OnlineAuction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
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
    @Autowired
    PicturePhotoService picturePhotoService;

    @GetMapping("/")
    public String index(Model model){
        Date currentDate = new Date();
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.allActivePlumbs(currentDate, new PageRequest(0, 12)));
        for (Plumb plumb: plumbs) {
            plumb.getPicture().setPicturePhotos(picturePhotoService.findAllByPicture(plumb.getPicture()));
            Bet bet = betService.findMaxBet(plumb);
            plumb.setBets(new ArrayList<Bet>());
            plumb.addBet(bet);
        }
        model.addAttribute("plumbs", plumbs);
        model.addAttribute("authors", authorService.findAllPageable(new PageRequest(0, 8)));
        model.addAttribute("currentDate", currentDate);
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
        List<Bet> betsToSoldPlumbWhereUserWasInvolved = betService.soldPlumbsWhereUserWasInvolved(user, currentDate, new PageRequest(0, 8));
        List<Plumb> winneredPlumbs = new ArrayList<Plumb>();
        for (Bet bet: betsToSoldPlumbWhereUserWasInvolved) {
            Bet winnerBet = betService.winnerBetOfPlumb(bet.getPlumb());
            if (user.getId() == winnerBet.getUser().getId()){
                winneredPlumbs.add(bet.getPlumb());
            }
        }
        for (Plumb plumb: winneredPlumbs) {
            plumb.getPicture().setPicturePhotos(picturePhotoService.findAllByPicture(plumb.getPicture()));
        }
        model.addAttribute("plumbWhichBoughtByUser", winneredPlumbs);
        model.addAttribute("user", user);
        model.addAttribute("describeOfUser", describeOfUser);
        model.addAttribute("plumbsWhichAddedByUser", plumbs);
        model.addAttribute("currentDate", currentDate);
        return "userPage";
    }

    @GetMapping("/describeOfUser{user}")
    public String describeOfUserPage(@PathVariable("user")String userName, Model model){
        model.addAttribute("userName", userName);
        return "describeOfUserPage";
    }

    @GetMapping("/user{userName}EnabledTrue")
    public String setEnabledTrue(@PathVariable("userName")String userName){
        userService.setEnabledTrue(userName);
        return "redirect:/";
    }

    @GetMapping("/email{email}/user{userName}")
    public String setEnabledTrue(@PathVariable("userName")String userName, @PathVariable("email")String email){
        userService.editEmailAddress(userName, email);
        return "redirect:/userPage" + userName;
    }

    @PostMapping("/loginSuccess")
    public String logMe() {
        return "redirect:/";
    }

    @PostMapping("/createDescribeOfUser{user}")
    public String createDescribeOfUser(@PathVariable("user")String userName, @RequestParam String name, @RequestParam String surname, @RequestParam String facebookURL,
                                       @RequestParam String phone, @RequestParam String country, @RequestParam String city, @RequestParam int zipCode){
        User user = userService.findByName(userName);
        DescribeOfUser describeOfUser = new DescribeOfUser(user, facebookURL, name, surname, phone, country, city, zipCode);
        describeOfUserService.save(describeOfUser);
        return "redirect:/userPage" + userName;
    }

    @GetMapping("/rules")
    public String goToRules(){
        return "rules";
    }


}
