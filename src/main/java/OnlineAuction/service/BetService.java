package OnlineAuction.service;


import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetService {

    void save(Bet bet);
    void delete(int id);
    Bet findOne(int id);
    List<Bet> findAll();
    Bet findMaxBet(Plumb plumb);
    int numberOfBets(Plumb plumb);
}
