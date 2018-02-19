package OnlineAuction.dao;

import OnlineAuction.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PictureDAO extends JpaRepository<Picture, Integer> {
}
