package OnlineAuction.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plumb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Picture picture;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    private int minPrise;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm" ,shape = JsonFormat.Shape.STRING,timezone = "Europe/Kiev")
    private Date currentDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm" ,shape = JsonFormat.Shape.STRING,timezone = "Europe/Kiev")
    private Date dateOfEnd;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "plumb")
    private List<Bet> bets;

    private boolean confirmed = false;

    public Plumb(Picture picture, User user, int minPrise, Date currentDate, Date dateOfEnd, boolean confirmed) {
        this.picture = picture;
        this.user = user;
        this.minPrise = minPrise;
        this.currentDate = currentDate;
        this.dateOfEnd = dateOfEnd;
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Plumb{" +
                "id=" + id +
                ", minPrise=" + minPrise +
                ", currentDate=" + currentDate +
                ", dateOfEnd=" + dateOfEnd +
                ", confirmed=" + confirmed +
//                ", picture=" + picture +
                ", bets=" + bets +
                '}';
    }

    public Picture getPicture() {
        return picture;
    }

    public void addBet(Bet bet) {
        this.bets.add(bet);
    }
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
