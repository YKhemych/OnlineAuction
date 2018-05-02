package OnlineAuction.service;


import OnlineAuction.entity.Author;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Plumb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PlumbService {

    void save(Plumb plumb);
    void delete(int id);
    Plumb findOne(int id);
    List<Plumb> findAll();
    List<Plumb> plumbWithoutConfirmed();
    Plumb findOneByIdWithPicture(int id);
    void confirmPlumb(int id);
    List<Plumb> allActivePlumbs(Date currentDate, Pageable pageRequest);
    List<Plumb> findActivePlumbByCategoryWithPictureAndPhoto(Category category, Date currentDate, Pageable pageRequest);
    List<Plumb> findAllPlumbByAuthorWithPictureAndPhoto(Author author, Pageable pageRequest);
}
