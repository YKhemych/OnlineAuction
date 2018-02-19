package OnlineAuction.dao;

import OnlineAuction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
