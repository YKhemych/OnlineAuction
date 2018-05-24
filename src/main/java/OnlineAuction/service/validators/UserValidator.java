package OnlineAuction.service.validators;

import OnlineAuction.entity.User;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Null;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User buff = userService.findByName(user.getUsername());
        if (buff != null){
            errors.rejectValue("username", "error", "This userName is present");
        }
    }
}
