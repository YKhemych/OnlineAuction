package OnlineAuction.service;


import OnlineAuction.entity.Picture;

import java.util.List;

public interface PictureService {

    void save(Picture picture);
    void delete(int id);
    Picture findOne(int id);
    List<Picture> findAll();
}
