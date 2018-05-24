package OnlineAuction.service.Impl;


import OnlineAuction.dao.AuthorDAO;
import OnlineAuction.entity.Author;
import OnlineAuction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    public Author findOne(int id) {
        return authorDAO.findOne(id);
    }

    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    public List<Author> findAllPageable(Pageable pageRequest) {
        return authorDAO.findAllPopular(pageRequest);
    }

    public int countAuthors() {
        return authorDAO.countAuthors();
    }

    public void removeAuthor(int id) {
        authorDAO.removeAuthor(id);
    }

    public Author findAuthorByName(String name) {
        return authorDAO.findAuthorByName(name);
    }

    @Override
    public void editBiography(String biography, int id) {
        authorDAO.editBiography(biography, id);
    }

}
