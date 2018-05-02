package OnlineAuction.dao;

import OnlineAuction.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AuthorDAO extends JpaRepository<Author, Integer> {

    @Query("from Author a")
    List<Author> findAllPageable(Pageable pageRequest);

    @Query("from Author a left join fetch a.pictures group by a.id order by count(a.id) desc ")
    List<Author> findAllPopular(Pageable pageRequest);

    @Query("select count(a.id) from Author a")
    int countAuthors();

    @Modifying
    @Query("delete from Author a where a.id = :removeId")
    void removeAuthor(@Param("removeId") int id);

    @Query("from Author a where a.name =:name")
    Author findAuthorByName(@Param("name")String name);

}
