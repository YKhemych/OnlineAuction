package OnlineAuction.service;

import OnlineAuction.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserService {

    void save(User user);
    void delete(int id);
    User findByName(String name);
    List<User> findAll();
    public UserDetails loadUserByUsername(String username);
    void editEmailAddress(String userName, String email);
    void changePassword(String userName, String newPassword);
    void blockUser(String userName);
    void unblockUser(String userName);
    void setEnabledTrue(String userName);
    void allowSendEmailTrue(String userName);
}
