package OnlineAuction.service.Impl;

import OnlineAuction.dao.PicturePhotoDAO;
import OnlineAuction.entity.Picture;
import OnlineAuction.entity.PicturePhoto;
import OnlineAuction.service.PicturePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PicturePhotoServiceImpl implements PicturePhotoService {

    @Autowired
    PicturePhotoDAO picturePhotoDAO;

    public void save(PicturePhoto picturePhoto) {
        picturePhotoDAO.save(picturePhoto);
    }

    public void delete(int id) {
        picturePhotoDAO.delete(id);
    }

    public void removeByPicture(Picture picture) {
        picturePhotoDAO.removeByPicture(picture);
    }

    public PicturePhoto findOne(int id) {
        return picturePhotoDAO.findOne(id);
    }

    public List<PicturePhoto> findAll() {
        return picturePhotoDAO.findAll();
    }

    public List<PicturePhoto> findAllByPicture(Picture picture) {
        return picturePhotoDAO.findAllByPicture(picture);
    }
}
