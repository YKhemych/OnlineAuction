package OnlineAuction.service;


import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DescribeOfUserService {

    void save(DescribeOfUser describeOfUser);
    DescribeOfUser findByUser(User user);
    void editNameOfUser(User user, String name);
    void editSurnameOfUser(User user, String surname);
    void editPhoneOfUser(User user, String phone);
    void editCountryOfUser(User user, String country);
    void editCityOfUser(User user, String city);
    void editZipCodeOfUser(User user, int zipCode);
}
