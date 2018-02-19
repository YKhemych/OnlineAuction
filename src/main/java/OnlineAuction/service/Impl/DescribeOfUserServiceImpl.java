package OnlineAuction.service.Impl;

import OnlineAuction.dao.DescribeOfUserDAO;
import OnlineAuction.entity.DescribeOfUser;
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

    public void delete(int id) {
        describeOfUserDAO.delete(id);
    }

    public DescribeOfUser findOne(int id) {
        return describeOfUserDAO.findOne(id);
    }

    public List<DescribeOfUser> findAll() {
        return describeOfUserDAO.findAll();
    }
}
