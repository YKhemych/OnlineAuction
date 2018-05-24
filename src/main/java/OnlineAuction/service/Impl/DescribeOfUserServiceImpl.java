package OnlineAuction.service.Impl;

import OnlineAuction.dao.DescribeOfUserDAO;
import OnlineAuction.entity.DescribeOfUser;
import OnlineAuction.entity.User;
import OnlineAuction.service.DescribeOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DescribeOfUserServiceImpl implements DescribeOfUserService {

    @Autowired
    DescribeOfUserDAO describeOfUserDAO;

    public void save(DescribeOfUser describeOfUser) {
        describeOfUserDAO.save(describeOfUser);
    }

    public DescribeOfUser findByUser(User user) {
        return describeOfUserDAO.findByUser(user);
    }

    public void editNameOfUser(User user, String name) {
        describeOfUserDAO.editNameOfUser(user, name);
    }

    public void editSurnameOfUser(User user, String surname) {
        describeOfUserDAO.editSurnameOfUser(user, surname);
    }

    public void editPhoneOfUser(User user, String phone) {
        describeOfUserDAO.editPhoneOfUser(user, phone);
    }

    public void editCountryOfUser(User user, String country) {
        describeOfUserDAO.editCountryOfUser(user, country);
    }

    public void editCityOfUser(User user, String city) {
        describeOfUserDAO.editCityOfUser(user, city);
    }

    public void editZipCodeOfUser(User user, int zipCode) {
        describeOfUserDAO.editZipCodeOfUser(user, zipCode);
    }

    @Override
    public void editFacebookURLofUser(User user, String facebookURL) {
        describeOfUserDAO.editFacebookURLofUser(user, facebookURL);
    }
}
