package OnlineAuction.dao;

import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DescribeOfUserDAO extends JpaRepository<DescribeOfUser,Integer> {

    @Query("from DescribeOfUser d where d.user = :user")
    DescribeOfUser findByUser(@Param("user")User user);

    @Modifying
    @Query("update DescribeOfUser d set d.name = :name where d.user = :user")
    void editNameOfUser(@Param("user")User user, @Param("name")String name);

    @Modifying
    @Query("update DescribeOfUser d set d.surname = :surname where d.user = :user")
    void editSurnameOfUser(@Param("user")User user, @Param("surname")String surname);

    @Modifying
    @Query("update DescribeOfUser d set d.phone = :phone where d.user = :user")
    void editPhoneOfUser(@Param("user")User user, @Param("phone")String phone);

    @Modifying
    @Query("update DescribeOfUser d set d.country = :country where d.user = :user")
    void editCountryOfUser(@Param("user")User user, @Param("country")String country);

    @Modifying
    @Query("update DescribeOfUser d set d.city = :city where d.user = :user")
    void editCityOfUser(@Param("user")User user, @Param("city")String city);

    @Modifying
    @Query("update DescribeOfUser d set d.zipCode = :zipCode where d.user = :user")
    void editZipCodeOfUser(@Param("user")User user, @Param("zipCode")int zipCode);

    @Modifying
    @Query("update DescribeOfUser d set d.facebookURL = :facebookURL where d.user = :user")
    void editFacebookURLofUser(@Param("user")User user, @Param("facebookURL")String facebookURL);
}
