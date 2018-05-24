package OnlineAuction.service.Impl;

import OnlineAuction.dao.PlumbDAO;
import OnlineAuction.entity.Author;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import OnlineAuction.service.PlumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        plumbDAO.removePlumb(id);
    }

    public Plumb findOne(int id) {
        return plumbDAO.findOne(id);
    }

    public List<Plumb> findAll() {
        return plumbDAO.findAll();
    }

    public List<Plumb> plumbWithoutConfirmed() {
        return plumbDAO.plumbWithoutConfirmed();
    }

    public Plumb findOneByIdWithPicture(int id) {
        return plumbDAO.findOneByIdWithPicture(id);
    }

    public void confirmPlumb(int id) {
        plumbDAO.confirmPlumb(id);
    }

    @Override
    public void confirmDeliverPlumb(int id) {
        plumbDAO.confirmDeliverPlumb(id);
    }

    public List<Plumb> allActivePlumbs(Date currentDate, Pageable pageRequest) {
        return plumbDAO.allActivePlumbs(currentDate, pageRequest);
    }

    public List<Plumb> findPlumbByCategoryWithPictureAndPhoto(Category category, Pageable pageRequest) {
        return plumbDAO.findPlumbByCategoryWithPictureAndPhoto(category, pageRequest);
    }

    public List<Plumb> findAllPlumbByAuthorWithPictureAndPhoto(Author author, Pageable pageRequest) {
        return plumbDAO.findAllPlumbByAuthorWithPictureAndPhoto(author, pageRequest);
    }

    public int countPlumbByCategory(Category category) {
        return plumbDAO.countPlumbByCategory(category);
    }

    @Override
    public int countPlumbsByAuthor(Author author) {
        return plumbDAO.countPlumbsByAuthor(author);
    }

    public int countActivePlumb(Date currentDate) {
        return plumbDAO.countActivePlumb(currentDate);
    }

    public List<Plumb> findAllPlumbWithPicture() {
        return plumbDAO.findAllPlumbWithPicture();
    }

    public List<Plumb> findPlumbByUser(User user, Pageable pageRequest) {
        return plumbDAO.findPlumbByUser(user, pageRequest);
    }

    public void resetPlumb(int id, Date dateOfEnd, Date currentDate) {
        plumbDAO.resetPlumb(id, dateOfEnd, currentDate);
    }

}
