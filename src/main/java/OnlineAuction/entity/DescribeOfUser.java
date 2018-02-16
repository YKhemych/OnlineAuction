package OnlineAuction.entity;


import lombok.*;

import javax.persistence.*;

/**
 * Created by user on 16.02.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DescribeOfUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    private String name;
    private String surname;
    private String phone;
    private String country;
    private String city;
    private String street;
    private int zipCode;


}
