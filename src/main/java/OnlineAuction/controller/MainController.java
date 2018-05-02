package OnlineAuction.controller;

import OnlineAuction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("authors", authorService.findAllPageable(new PageRequest(0, 8)));

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



}
