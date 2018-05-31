package OnlineAuction.controller;

import OnlineAuction.dao.AuthorDAO;
import OnlineAuction.entity.Author;
import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import OnlineAuction.service.AuthorService;
import OnlineAuction.service.BetService;
import OnlineAuction.service.PlumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private PlumbService plumbService;
    @Autowired
    private BetService betService;

    @GetMapping("/admin/createAuthor")
    public String createAuthor(){
        return "createAuthor";
    }

    @PostMapping("/create/saveAuthor")
    public String saveAuthor(@RequestParam String name, @RequestParam MultipartFile photo, @RequestParam String biography) throws IOException {
        String realPath = System.getProperty("user.home") + File.separator + "auctionImages" + File.separator;
        photo.transferTo(new File(realPath + photo.getOriginalFilename()));
        Author author = Author
                .builder()
                .name(name)
                .photo("/photo/" + photo.getOriginalFilename())
                .biography(biography)
                .build();
        authorService.save(author);
        System.out.println(author);
        return "redirect:/admin/adminPage";
    }

    @GetMapping("/allAuthorsPage-{page}")
    public String allAuthors(@PathVariable("page")int page, Model model){
        List<Author> authors = new ArrayList<Author>(authorService.findAllPageable(new PageRequest(page, 20)));
        int maxPage = (int) Math.ceil((authorService.countAuthors() - 1) / 20 + 1);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("authors", authors);
        model.addAttribute("authorsPage", page);
        System.out.println(maxPage);
        return "listAuthors";
    }

    @GetMapping("/authorWithId{id}/Page{page}")
    public String authorWithId(@PathVariable("id")int id, @PathVariable("page")int page, Model model){
        Author author = authorService.findOne(id);
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.findAllPlumbByAuthorWithPictureAndPhoto(author, new PageRequest(page, 12)));
        for (Plumb plumb: plumbs) {
            Bet bet = betService.findMaxBet(plumb);
            plumb.setBets(new ArrayList<Bet>());
            plumb.addBet(bet);
        }
        int maxPage = (int) Math.ceil((plumbService.countPlumbsByAuthor(author) - 1) / 20 + 1);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("author", author);
        model.addAttribute("plumbs", plumbs);
        model.addAttribute("authorsPage", page);
        model.addAttribute("currentDate", new Date());
        return "authorPage";
    }

}
