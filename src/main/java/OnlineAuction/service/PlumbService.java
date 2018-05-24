package OnlineAuction.service;


import OnlineAuction.entity.Author;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
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
    void confirmDeliverPlumb(int id);
    List<Plumb> allActivePlumbs(Date currentDate, Pageable pageRequest);
    List<Plumb> findPlumbByCategoryWithPictureAndPhoto(Category category, Pageable pageRequest);
    List<Plumb> findAllPlumbByAuthorWithPictureAndPhoto(Author author, Pageable pageRequest);
    int countPlumbByCategory(Category category);
    int countPlumbsByAuthor(Author author);
    int countActivePlumb(Date currentDate);
    List<Plumb> findAllPlumbWithPicture();
    List<Plumb> findPlumbByUser(User user, Pageable pageRequest);
    void resetPlumb(int id, Date dateOfEnd, Date currentDate);
}
