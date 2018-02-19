package OnlineAuction.service;


import OnlineAuction.entity.Author;

import java.util.List;


public interface AuthorService {
    void save(Author author);
    void delete(int id);
    Author findOne(int id);
    List<Author> findAll();
}
