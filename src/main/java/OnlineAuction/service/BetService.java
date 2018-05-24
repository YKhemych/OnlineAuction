package OnlineAuction.service;


import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BetService {

    void save(Bet bet);
    void removeBets(Plumb plumb);
    Bet findOne(int id);
    Bet findMaxBet(Plumb plumb);
    int numberOfBets(Plumb plumb);
    Bet winnerBetOfPlumb(Plumb plumb);
    List<Bet> soldPlumbsWhereUserWasInvolved(User user, Date currentDate, Pageable pageRequest);
}
