package OnlineAuction.service;


import OnlineAuction.entity.Category;
import OnlineAuction.entity.Picture;
import OnlineAuction.entity.Plumb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PictureService {

    void save(Picture picture);
    void delete(int id);
    Picture findOne(int id);
    List<Picture> findAll();
    List<Picture> findActivePictureByCategoryWithPlumbAndPhoto(Category category, Date currentDate, Pageable pageRequest);
}
