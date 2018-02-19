package OnlineAuction.service.Impl;


import OnlineAuction.dao.AuthorDAO;
import OnlineAuction.entity.Author;
import OnlineAuction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    public void save(Author author) {
        authorDAO.save(author);
    }

    public void delete(int id) {
        authorDAO.delete(id);
    }

    public Author findOne(int id) {
        return authorDAO.findOne(id);
    }

    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}
