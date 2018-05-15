package OnlineAuction.controller;

import OnlineAuction.entity.*;
import OnlineAuction.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlumbRestController {

    @Autowired
    PlumbService plumbService;
    @Autowired
    PictureService pictureService;
    @Autowired
    PicturePhotoService picturePhotoService;
    @Autowired
    BetService betService;
    @Autowired
    UserService userService;

    @GetMapping("/plumbWithoutConfirmed")
    public List<Plumb> plumbWithoutConfirmed() {
        return plumbService.plumbWithoutConfirmed();
    }

    @DeleteMapping("/deletePlumb{id}")
    public void deletePlumb(@PathVariable("id") int deleteId) {
        Plumb plumb = plumbService.findOneByIdWithPicture(deleteId);
        Picture picture = plumb.getPicture();
        picturePhotoService.removeByPicture(picture);
        plumbService.delete(deleteId);
        pictureService.delete(picture.getId());

    }

    @GetMapping("/allPlumbs")
    public List<Plumb> allPlumbs() {
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.findAllPlumbWithPicture());
        return plumbs;
    }

    @PostMapping("/makeBetTo{id}By{userName}")
    public void saveBet(@RequestBody String betSize, @PathVariable("id") int id, @PathVariable("userName") String userName) {
        int buffBetSize = Integer.parseInt(betSize);
        User user = userService.findByName(userName);
        Plumb plumb = plumbService.findOne(id);
        Bet bet = new Bet(user, buffBetSize, plumb);
        betService.save(bet);
    }

    @GetMapping("/numberOfBetIn{plumbId}")
    public int numberOfBet(@PathVariable("plumbId")int plumbId){
        return betService.numberOfBets(plumbService.findOne(plumbId));
    }
    @GetMapping("/maxBetIn{plumbId}")
    public Bet maxBet(@PathVariable("plumbId")int plumbId){
        return betService.findMaxBet(plumbService.findOne(plumbId));
    }
}
