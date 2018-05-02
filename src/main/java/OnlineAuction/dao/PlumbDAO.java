package OnlineAuction.dao;



import OnlineAuction.entity.Author;
import OnlineAuction.entity.Category;
import OnlineAuction.entity.Plumb;
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

    @Query("from Plumb p left join fetch p.picture where p.id =:id")
    Plumb findOneByIdWithPicture(@Param("id")int id);

    @Modifying
    @Query("delete from Plumb p where p.id = :removeId")
    void removePlumb(@Param("removeId") int id);

    @Modifying
    @Query("update Plumb p set p.confirmed = true where p.id = :plumbId")
    void confirmPlumb(@Param("plumbId")int id);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.confirmed = 1 and p.dateOfEnd > :currentDate group by p.id")
    List<Plumb> allActivePlumbs(@Param("currentDate")Date currentDate, Pageable pageRequest);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.confirmed = 1 and p.dateOfEnd > :currentDate and p.picture.category = :category group by p.id")
    List<Plumb> findActivePlumbByCategoryWithPictureAndPhoto(@Param("category")Category category, @Param("currentDate")Date currentDate, Pageable pageRequest);

    @Query("from Plumb p left join fetch p.picture left join fetch p.picture.picturePhotos where p.picture.author = :author group by p.id")
    List<Plumb> findAllPlumbByAuthorWithPictureAndPhoto(@Param("author")Author author, Pageable pageRequest);
}
