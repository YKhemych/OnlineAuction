package OnlineAuction.controller;

import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import OnlineAuction.service.BetService;
import OnlineAuction.service.MailService;
import OnlineAuction.service.PlumbService;
import OnlineAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetRestController {

    @Autowired
    PlumbService plumbService;
    @Autowired
    BetService betService;
    @Autowired
    MailService mailService;
    @Autowired
    UserService userService;

    @PostMapping("/makeBetTo{id}By{userName}")
    public void saveBet(@RequestBody String betSize, @PathVariable("id") int id, @PathVariable("userName") String userName) {
        Plumb plumb = plumbService.findOne(id);
        Bet maxBet = betService.findMaxBet(plumb);
        if (maxBet !=  null){
            if (maxBet.getUser().isAllowSendEmail() == true){
                String message = "Hello " + maxBet.getUser().getUsername() + ". Another person put higher bet then you. <a href='http://localhost:8080/plumb" + id + "'>Look at this plumb</a>";
                mailService.sendByUser(maxBet.getUser(), message);
            }
        }
        int buffBetSize = Integer.parseInt(betSize);
        User user = userService.findByName(userName);
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
