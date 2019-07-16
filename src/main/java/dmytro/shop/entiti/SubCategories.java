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
public class SubCategories {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable =  false)
    private String name;

    @ManyToOne
    private Category category;


    @OneToMany(mappedBy = "subCategories")
    private List<Product> products = new ArrayList<>();

    @ManyToMany(mappedBy = "subCategories")
    private List<Spec> spec = new ArrayList<>();
}
