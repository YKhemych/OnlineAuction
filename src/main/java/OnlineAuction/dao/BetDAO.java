package OnlineAuction.dao;

import OnlineAuction.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BetDAO extends JpaRepository<Bet, Integer> {
}
