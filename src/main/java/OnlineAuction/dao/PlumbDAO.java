package OnlineAuction.dao;



import OnlineAuction.entity.Author;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface PlumbDAO extends JpaRepository<Plumb, Integer> {

    @Query("from Plumb p left join fetch p.picture left join fetch p.user where p.confirmed = 0")
    List<Plumb> plumbWithoutConfirmed();

    @Query("from Plumb p left join fetch p.user left join fetch p.picture left join fetch p.picture.author left join fetch p.picture.category where p.id =:id")
    Plumb findOneByIdWithPicture(@Param("id")int id);

    @Modifying
    @Query("delete from Plumb p where p.id = :removeId")
    void removePlumb(@Param("removeId") int id);

    @Modifying
    @Query("update Plumb p set p.confirmed = true where p.id = :plumbId")
    void confirmPlumb(@Param("plumbId")int id);

    @Modifying
    @Query("update Plumb p set p.delivered = true where p.id = :plumbId")
    void confirmDeliverPlumb(@Param("plumbId")int id);

    @Modifying
    @Query("update Plumb p set p.confirmed = false, p.dateOfEnd = :dateOfEnd, p.currentDate = :currentDate where p.id = :plumbId")
    void resetPlumb(@Param("plumbId")int id, @Param("dateOfEnd")Date dateOfEnd, @Param("currentDate")Date currentDate);
    
    @Query("from Plumb p left join fetch p.picture left join fetch p.bets where p.confirmed = 1 and p.dateOfEnd > :currentDate group by p.id order by count(p.id) desc")
    List<Plumb> allActivePlumbs(@Param("currentDate")Date currentDate, Pageable pageRequest);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.confirmed = 1 and p.picture.category = :category group by p.id order by p.dateOfEnd desc ")
    List<Plumb> findPlumbByCategoryWithPictureAndPhoto(@Param("category")Category category, Pageable pageRequest);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.picture.author = :author group by p.id order by p.id desc")
    List<Plumb> findAllPlumbByAuthorWithPictureAndPhoto(@Param("author")Author author, Pageable pageRequest);

    @Query("from Plumb p left join fetch p.picture left join fetch p.user group by p.id")
    List<Plumb> findAllPlumbWithPicture();

    @Query("select count(p.id) from Plumb p where p.dateOfEnd > :currentDate and p.confirmed = 1")
    int countActivePlumb(@Param("currentDate")Date currentDate);

    @Query("select count(p.id) from Picture p where p.category = :category")
    int countPlumbByCategory(@Param("category")Category category);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.user= :user group by p.id order by p.currentDate desc")
    List<Plumb> findPlumbByUser(@Param("user")User user, Pageable pageRequest);

    @Query("select count(p.id) from Picture p where p.author = :author")
    int countPlumbsByAuthor(@Param("author")Author author);

}
