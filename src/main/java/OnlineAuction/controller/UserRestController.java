package OnlineAuction.controller;

import OnlineAuction.entity.User;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    public String saveUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return result.getFieldError().getField();
        } else {
            userService.save(user);
            return null;
        }

    }




}
