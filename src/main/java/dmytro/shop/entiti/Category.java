package dmytro.shop.entiti;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable =  false)
    private String name;


    @OneToMany(mappedBy = "category")
    private List<SubCategories> subCategories = new ArrayList<>();

}
