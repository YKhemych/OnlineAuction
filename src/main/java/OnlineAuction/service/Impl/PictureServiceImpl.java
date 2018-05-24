package OnlineAuction.service.Impl;

import OnlineAuction.dao.PictureDAO;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Picture;
import OnlineAuction.entity.Plumb;
import OnlineAuction.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        pictureDAO.removePicture(id);
    }

    public Picture findOne(int id) {
        return pictureDAO.findOne(id);
    }

    public List<Picture> findAll() {
        return pictureDAO.findAll();
    }

    public List<Picture> findActivePictureByCategoryWithPlumbAndPhoto(Category category, Date currentDate, Pageable pageRequest) {
        return pictureDAO.findActivePictureByCategoryWithPlumbAndPhoto(category, pageRequest);
    }

    public void editPlumbName(String name, int pictureId) {
        pictureDAO.editPlumbName(name, pictureId);
    }

    public void editPlumbCategory(Category category, int pictureId) {
        pictureDAO.editPlumbCategory(category, pictureId);
    }

}
