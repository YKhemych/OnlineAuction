package OnlineAuction.service.Impl;

import OnlineAuction.dao.UserDAO;
import OnlineAuction.entity.User;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    UserDAO userDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    public void editEmailAddress(String userName, String email) {
        userDAO.editEmailAddress(userName, email);
    }

    public void changePassword(String userName, String newPassword) {
        String password = passwordEncoder.encode(newPassword);
        userDAO.changePassword(userName, password);
    }
}
