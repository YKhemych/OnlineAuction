package OnlineAuction.dao;

import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BetDAO extends JpaRepository<Bet, Integer> {

    @Query("from Bet b where b.plumb =:plumb and b.price = (select max(bb.price) from Bet bb where bb.plumb =:plumb)")
    Bet findMaxBet(@Param("plumb") Plumb plumb);

    @Query("select count(b.id) from Bet b where b.plumb =:plumb")
    int numberOfBets(@Param("plumb")Plumb plumb);
}
