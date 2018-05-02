package OnlineAuction.service;


import OnlineAuction.entity.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorService{
    void save(Author author);
    Author findOne(int id);
    List<Author> findAll();
    List<Author> findAllPageable(Pageable pageRequest);
    int countAuthors();
    void removeAuthor(int id);
    Author findAuthorByName(String name);
}
