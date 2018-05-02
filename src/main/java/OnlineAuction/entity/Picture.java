package OnlineAuction.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "picture")
    private List<PicturePhoto> picturePhotos;
    @Column(length = 55)
    private String name;
    @Column(length = 10)
    private String size;
    @Column(length = 10)
    private String year;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Author author;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Category category;
    @Column(length = 100)
    private String material;
    private String conditions;
    private String descriptions;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "picture")
    private Plumb plumb;


    public Picture(String name, String size, String year, Author author, Category category, String material, String condition, String description) {
        this.name = name;
        this.size = size;
        this.year = year;
        this.author = author;
        this.category = category;
        this.material = material;
        this.conditions = condition;
        this.descriptions = description;
    }

    public Picture() {
    }

    public Picture(String name, String size, String year) {
        this.name = name;
        this.size = size;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", year='" + year + '\'' +
                ", material='" + material + '\'' +
                ", conditions='" + conditions + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", picturePhotos='" + picturePhotos + '\'' +
//                ", plumb='" + plumb + '\'' +
                '}';
    }
}
