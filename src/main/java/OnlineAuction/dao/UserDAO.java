package OnlineAuction.dao;

import OnlineAuction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("from User u where u.username = :name")
    User findByName(@Param("name") String name);

    @Modifying
    @Query("update User u set u.email = :email where u.username = :userName")
    void editEmailAddress(@Param("userName")String userName, @Param("email")String email);

    @Modifying
    @Query("update User u set u.password = :password where u.username = :userName")
    void changePassword(@Param("userName")String userName, @Param("password")String password);

    @Modifying
    @Query("update User u set u.accountNonLocked = false where u.username = :userName")
    void blockUser(@Param("userName")String userName);

    @Modifying
    @Query("update User u set u.accountNonLocked = true where u.username = :userName")
    void unblockUser(@Param("userName")String userName);

    @Modifying
    @Query("update User u set u.enabled = true where u.username = :userName")
    void setEnabledTrue(@Param("userName")String userName);

    @Modifying
    @Query("update User u set u.allowSendEmail = true where u.username = :userName")
    void allowSendEmailTrue(@Param("userName")String userName);

}
