package OnlineAuction.service.Impl;

import OnlineAuction.dao.CategoryDAO;
import OnlineAuction.entity.Category;
import OnlineAuction.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public void save(Category category) {
        categoryDAO.save(category);
    }

    public Category findOne(int id) {
        return categoryDAO.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public void renameCategory(int id, String newName) {
        categoryDAO.renameCategory(id, newName);
    }

    public void changeIdFatherCategory(int id, int newIdFatherCategories) {
        categoryDAO.changeIdFatherCategory(id, newIdFatherCategories);
    }

    public void delete(int id) {
        categoryDAO.removeCategory(id);
    }

    public Category findCategoryByName(String name) {
        return categoryDAO.findCategoryByName(name);
    }
}
