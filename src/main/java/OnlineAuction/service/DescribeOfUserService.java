package OnlineAuction.service;


import OnlineAuction.entity.DescribeOfUser;

import java.util.List;

public interface DescribeOfUserService {

    void save(DescribeOfUser describeOfUser);
    void delete(int id);
    DescribeOfUser findOne(int id);
    List<DescribeOfUser> findAll();
}
