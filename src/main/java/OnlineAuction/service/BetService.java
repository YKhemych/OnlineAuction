package OnlineAuction.service;


import OnlineAuction.entity.Bet;

import java.util.List;

public interface BetService {

    void save(Bet bet);
    void delete(int id);
    Bet findOne(int id);
    List<Bet> findAll();
}
