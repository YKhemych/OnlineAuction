package OnlineAuction.dao;


import OnlineAuction.entity.Picture;
import OnlineAuction.entity.PicturePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PicturePhotoDAO extends JpaRepository<PicturePhoto, Integer> {

    @Modifying
    @Query("delete from PicturePhoto pp where pp.picture = :picture")
    void removeByPicture(@Param("picture") Picture picture);

    @Query("from PicturePhoto pp where pp.picture = :picture")
    List<PicturePhoto> findAllByPicture(@Param("picture") Picture picture);

}
