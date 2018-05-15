package OnlineAuction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    private int price;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Plumb plumb;

    public Bet(User user, int price, Plumb plumb) {
        this.user = user;
        this.price = price;
        this.plumb = plumb;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
