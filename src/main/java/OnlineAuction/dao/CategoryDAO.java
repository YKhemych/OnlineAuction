package OnlineAuction.dao;


import OnlineAuction.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

    @Modifying
    @Query("update Category c set c.name = :newName where c.id = :idCategory")
    void renameCategory(@Param("idCategory")int id, @Param("newName")String newName);

    @Modifying
    @Query("update Category c set c.idFatherCategories = :newIdFatherCategories where c.id = :idCategory")
    void changeIdFatherCategory(@Param("idCategory")int id, @Param("newIdFatherCategories")int newIdFatherCategories);

    @Query("from Category c where c.idFatherCategories = :idFatherCategory")
    List<Category> findAllWithIdFatherCategory(@Param("idFatherCategory") int idFatherCategory);
}
