package OnlineAuction.entity;

import javax.persistence.*;

/**
 * Created by user on 16.02.2018.
 */
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    private int price;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Plumb plumb;
}
