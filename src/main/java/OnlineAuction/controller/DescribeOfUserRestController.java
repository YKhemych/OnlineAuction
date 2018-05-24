package OnlineAuction.controller;

import OnlineAuction.entity.User;
import OnlineAuction.service.DescribeOfUserService;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescribeOfUserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private DescribeOfUserService describeOfUserService;

    @PostMapping("/editName-{userLogin}")
    public void editNameOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String name){
        User user = userService.findByName(userLogin);
        describeOfUserService.editNameOfUser(user, name);
    }

    @PostMapping("/editSurname-{userLogin}")
    public void editSurnameOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String surname){
        User user = userService.findByName(userLogin);
        describeOfUserService.editSurnameOfUser(user, surname);
    }

    @PostMapping("/editFacebookURL-{userLogin}")
    public void editFacebookURLOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String facebookURL){
        User user = userService.findByName(userLogin);
        describeOfUserService.editFacebookURLofUser(user, facebookURL);
    }

    @PostMapping("/editPhone-{userLogin}")
    public void editPhoneOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String phone){
        User user = userService.findByName(userLogin);
        describeOfUserService.editPhoneOfUser(user, phone);
    }

    @PostMapping("/editCountry-{userLogin}")
    public void editCountryOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String country){
        User user = userService.findByName(userLogin);
        describeOfUserService.editCountryOfUser(user, country);
    }

    @PostMapping("/editCity-{userLogin}")
    public void editCityOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String city){
        User user = userService.findByName(userLogin);
        describeOfUserService.editCityOfUser(user, city);
    }

    @PostMapping("/editZipCode-{userLogin}")
    public void editZipCodeOfUser(@PathVariable("userLogin")String userLogin, @RequestBody String zipCode){
        int buffZipCode = Integer.parseInt(zipCode);
        User user = userService.findByName(userLogin);
        describeOfUserService.editZipCodeOfUser(user, buffZipCode);
    }

}
