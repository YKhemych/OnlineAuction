package OnlineAuction.controller;

import OnlineAuction.entity.Category;
import OnlineAuction.service.AuthorService;
import OnlineAuction.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/saveCategory")
    public void saveCategory(@RequestBody Category jsonCategorySave){
        categoryService.save(jsonCategorySave);
    }

    @DeleteMapping("/deleteCategory-{id}")
    public void deleteCategory(@PathVariable("id")int deleteId){
        categoryService.delete(deleteId);
    }

    @GetMapping("/allCategory")
    public List<Category> allCategories(){
        return categoryService.findAll();
    }


    @PostMapping("/changeNameCategory")
    public void renameCategory(@RequestBody Category jsonCategoryRename){
        categoryService.renameCategory(jsonCategoryRename.getId(), jsonCategoryRename.getName());
    }

    @PostMapping("/changeIdFatherCategory")
    public void changeIdFatherCategory(@RequestBody Category jsonCategoryChangeIDFC){
        categoryService.changeIdFatherCategory(jsonCategoryChangeIDFC.getId(), jsonCategoryChangeIDFC.getIdFatherCategories());
    }


}
