package OnlineAuction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PicturePhoto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photo;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Picture picture;

    public PicturePhoto(String photo, Picture picture){
        this.photo = photo;
        this.picture = picture;
    };

    @Override
    public String toString() {
        return "PicturePhoto{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                '}';
    }



}
