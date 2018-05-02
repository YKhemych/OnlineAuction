package OnlineAuction.service;

import OnlineAuction.entity.Picture;
import OnlineAuction.entity.PicturePhoto;

import java.util.List;

public interface PicturePhotoService {

    void save(PicturePhoto picturePhoto);
    void delete(int id);
    void removeByPicture(Picture picture);
    PicturePhoto findOne(int id);
    List<PicturePhoto> findAll();
    List<PicturePhoto> findAllByPicture(Picture picture);

}
