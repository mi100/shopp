package dmytro.shop.entiti;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Spec {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable =  false)
    private String name;



    @ManyToMany
    private List<SubCategories> subCategories = new ArrayList<>();

    @OneToMany(mappedBy = "spec")
    private List<SpecValue> specValue = new ArrayList<>();
}
