package OnlineAuction.dao;

import OnlineAuction.entity.Category;
import OnlineAuction.entity.Picture;
import OnlineAuction.entity.Plumb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface PictureDAO extends JpaRepository<Picture, Integer> {

    @Modifying
    @Query("delete from Picture p where p.id = :removeId")
    void removePicture(@Param("removeId") int id);

    @Query("from Picture p left join fetch p.plumb where p.category =:category group by p.id")
    List<Picture> findActivePictureByCategoryWithPlumbAndPhoto(@Param("category")Category category, Pageable pageRequest);

    @Modifying
    @Query("update Picture p set p.name = :newName where p.id = :pictureId")
    void editPlumbName(@Param("newName")String name, @Param("pictureId")int pictureId);

    @Modifying
    @Query("update Picture p set p.category = :category where p.id = :pictureId")
    void editPlumbCategory(@Param("category")Category category, @Param("pictureId")int pictureId);
}
