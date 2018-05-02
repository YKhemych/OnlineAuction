package OnlineAuction.controller;

import OnlineAuction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @Autowired
    private AuthorService authorService;

    @DeleteMapping("/deleteAuthor{id}")
    public void deleteAuthor(@PathVariable("id")int id){
        authorService.removeAuthor(id);
    }
}
