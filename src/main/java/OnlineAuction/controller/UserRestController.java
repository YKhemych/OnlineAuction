package OnlineAuction.controller;

import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.User;
import OnlineAuction.service.DescribeOfUserService;
import OnlineAuction.service.MailService;
import OnlineAuction.service.UserService;
import OnlineAuction.service.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserValidator userValidator;

    @InitBinder("user")
    public void bind(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

    @GetMapping("/user{userName}")
    public User findUserByUserName(@PathVariable("userName")String userName){
        return userService.findByName(userName);
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return result.getFieldError().getField();
        } else {
            String message = "Activate your account click <a href='http://localhost:8080/user" + user.getUsername() + "EnabledTrue'>here</a>";
            mailService.sendByUser(user, message);
            userService.save(user);
            return null;
        }

    }

    @PostMapping("/editEmail-{userLogin}")
    public void editEmailAddress(@PathVariable("userLogin")String userLogin, @RequestBody String email){
        String message = "Hello " + userLogin + ". You want to change your email. Please click <a href='http://localhost:8080/email" + email + "/user" + userLogin +"'>here</a>";
        mailService.sendByEmail(email, message);
    }

    @PostMapping("/sendConfirmationCodeTo-{userLogin}")
    public void sendConfirmationCode(@PathVariable("userLogin")String userLogin, @RequestBody String code){
        User user = userService.findByName(userLogin);
        String message = "Hello " + user.getUsername() + ". You want to change your password. It`s your confirmation code:"  + code;
        mailService.sendByUser(user, message);
    }

    @PostMapping("/allowSendEmailTo{userName}")
    public void allowSendEmail(@PathVariable("userName")String userName){
        userService.allowSendEmailTrue(userName);
    }

    @PostMapping("/editPassword-{userLogin}")
    public void changePassword(@PathVariable("userLogin")String userLogin, @RequestBody String newPassword){
        userService.changePassword(userLogin, newPassword);
    }

    @PostMapping("/admin/blockUser-{userLogin}")
    public void blockUser(@PathVariable("userLogin")String userLogin){
        userService.blockUser(userLogin);
    }

    @PostMapping("/admin/unblockUser-{userLogin}")
    public void unblockUser(@PathVariable("userLogin")String userLogin){
        userService.unblockUser(userLogin);
    }

}
