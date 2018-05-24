package OnlineAuction.service.Impl;

import OnlineAuction.dao.BetDAO;
import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import OnlineAuction.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BetServiceImpl implements BetService {

    @Autowired
    BetDAO betDAO;

    public void save(Bet bet) {
        betDAO.save(bet);
    }

    @Override
    public void removeBets(Plumb plumb) {
        betDAO.removeBets(plumb);
    }

    public void delete(int id) {
        betDAO.delete(id);
    }

    public Bet findOne(int id) {
        return betDAO.findOne(id);
    }

    public List<Bet> findAll() {
        return betDAO.findAll();
    }

    public Bet findMaxBet(Plumb plumb) {
        return betDAO.findMaxBet(plumb);
    }

    public int numberOfBets(Plumb plumb) {
        return betDAO.numberOfBets(plumb);
    }

    public Bet winnerBetOfPlumb(Plumb plumb) {
        return betDAO.winnerBetOfPlumb(plumb);
    }

    public List<Bet> soldPlumbsWhereUserWasInvolved(User user, Date currentDate, Pageable pageRequest) {
        return betDAO.soldPlumbsWhereUserWasInvolved(user, currentDate, pageRequest);
    }
}
