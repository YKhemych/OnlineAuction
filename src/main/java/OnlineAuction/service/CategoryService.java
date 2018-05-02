package OnlineAuction.service;

import OnlineAuction.entity.Category;

import java.util.List;


public interface CategoryService {
    void save(Category category);
    Category findOne(int id);
    List<Category> findAll();
    void renameCategory(int id, String newName);
    void changeIdFatherCategory(int id, int newIdFatherCategories);
    void delete(int id);
    Category findCategoryByName(String name);
}
