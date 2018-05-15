package OnlineAuction.controller;

import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.User;
import OnlineAuction.service.DescribeOfUserService;
import OnlineAuction.service.MailService;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private DescribeOfUserService describeOfUserService;


    @PostMapping("/saveUser")
    public String saveUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return result.getFieldError().getField();
        } else {
            userService.save(user);
            return null;
        }

    }

    @PostMapping("/editEmail-{userLogin}")
    public void editEmailAddress(@PathVariable("userLogin")String userLogin, @RequestBody String email){
        System.out.println(userLogin);
        System.out.println(email);
        userService.editEmailAddress(userLogin, email);
    }

    @PostMapping("/sendConfirmationCodeTo-{userLogin}")
    public void sendConfirmationCode(@PathVariable("userLogin")String userLogin, @RequestBody String code){
        System.out.println(code);
        System.out.println(userLogin);
        User user = userService.findByName(userLogin);
        String message = "Hello " + user.getUsername() + " you want to change your password. It is your confirmation code :"  + code;
//        mailService.sendByUser(user, message);
    }

    @PostMapping("/editPassword-{userLogin}")
    public void changePassword(@PathVariable("userLogin")String userLogin, @RequestBody String newPassword){
        userService.changePassword(userLogin, newPassword);
    }

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
