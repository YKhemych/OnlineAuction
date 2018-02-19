package OnlineAuction.service.Impl;

import OnlineAuction.dao.PictureDAO;
import OnlineAuction.entity.Picture;
import OnlineAuction.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PictureServiceImpl implements PictureService{

    @Autowired
    PictureDAO pictureDAO;

    public void save(Picture picture) {
        pictureDAO.save(picture);
    }

    public void delete(int id) {
        pictureDAO.delete(id);
    }

    public Picture findOne(int id) {
        return pictureDAO.findOne(id);
    }

    public List<Picture> findAll() {
        return pictureDAO.findAll();
    }
}
