package OnlineAuction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/admin/adminPage")
    public String adminPage(Model model){
        return "adminPage";
    }

    @GetMapping("/userPage")
    public String userPage(){
        return "userPage";
    }


    @PostMapping("/asd")
    public String logMe() {
        return "redirect:/";
    }


    @GetMapping("/admin/addProductToCategory-{id}")
    public String adminAddProduct(@PathVariable("id")int categoryId, Model model){
        model.addAttribute("categoryId", categoryId);
        return "addProduct";
    }

    @GetMapping("/productPage")
    public String productPage(Model model){
        return "productPage";
    }

}
