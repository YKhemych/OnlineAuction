package OnlineAuction.controller;

import OnlineAuction.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @DeleteMapping("/deleteAuthor{id}")
    public void deleteAuthor(@PathVariable("id")int id){
        authorService.removeAuthor(id);
    }

    @PostMapping("/editAuthorBiography-{authorId}")
    public void editPlumbName(@PathVariable("authorId")int authorId, @RequestBody String newBiography){
        System.out.println(authorId);
        System.out.println(newBiography);
        authorService.editBiography(newBiography, authorId);
    }
}
