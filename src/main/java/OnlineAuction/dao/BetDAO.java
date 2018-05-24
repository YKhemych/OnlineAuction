package OnlineAuction.dao;

import OnlineAuction.entity.Bet;
import OnlineAuction.entity.Plumb;
import OnlineAuction.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface BetDAO extends JpaRepository<Bet, Integer> {

    @Modifying
    @Query("delete from Bet b where b.plumb = :plumb")
    void removeBets(@Param("plumb") Plumb plumb);

    @Query("from Bet b left join fetch b.user where b.plumb =:plumb and b.price = (select max(bb.price) from Bet bb where bb.plumb =:plumb)")
    Bet findMaxBet(@Param("plumb") Plumb plumb);

    @Query("select count(b.id) from Bet b where b.plumb =:plumb")
    int numberOfBets(@Param("plumb")Plumb plumb);

    @Query("from Bet b left join fetch b.user where b.plumb =:plumb and b.price = (select max(bb.price) from Bet bb where bb.plumb =:plumb)")
    Bet winnerBetOfPlumb(@Param("plumb") Plumb plumb);

    @Query("from Bet b left join fetch b.plumb left join fetch b.plumb.picture where b.user= :user and b.plumb.dateOfEnd <:currentDate and b.plumb.confirmed = 1 group by b.plumb.id order by b.plumb.id desc")
    List<Bet> soldPlumbsWhereUserWasInvolved(@Param("user")User user, @Param("currentDate")Date currentDate, Pageable pageRequest);
}
