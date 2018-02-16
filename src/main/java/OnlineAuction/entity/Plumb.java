package OnlineAuction.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    private Picture picture;

    private User owner;

    private int minPrise;

    private Date currentDate;
    private Date dateOfEnd;
}
