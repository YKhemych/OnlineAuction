package OnlineAuction.service.Impl;

import OnlineAuction.dao.PlumbDAO;
import OnlineAuction.entity.Plumb;
import OnlineAuction.service.PlumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlumbServiceImpl implements PlumbService{

    @Autowired
    PlumbDAO plumbDAO;

    public void save(Plumb plumb) {
        plumbDAO.save(plumb);
    }

    public void delete(int id) {
        plumbDAO.delete(id);
    }

    public Plumb findOne(int id) {
        return plumbDAO.findOne(id);
    }

    public List<Plumb> findAll() {
        return plumbDAO.findAll();
    }
}
