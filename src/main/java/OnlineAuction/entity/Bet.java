package OnlineAuction.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
