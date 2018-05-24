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
    private String facebookURL;
    private String name;
    private String surname;
    private String phone;
    private String country;
    private String city;
    private int zipCode;

    public DescribeOfUser(User user, String facebookURL, String name, String surname, String phone, String country, String city, int zipCode) {
        this.user = user;
        this.facebookURL = facebookURL;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }
}
