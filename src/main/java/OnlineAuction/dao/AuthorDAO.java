package OnlineAuction.dao;

import OnlineAuction.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorDAO extends JpaRepository<Author, Integer> {
}
