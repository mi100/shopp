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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable =  false)
    private String name;

    @Column(unique = true, nullable =  false)
    private Integer price;

    private String pathToImg;

    private Integer quantitySold;  //кількість проданих

    private Integer balance;     //баланс

    private  Integer countLike;

    @ManyToOne
    private SubCategories subCategories;

    @OneToMany(mappedBy = "product")
    private List<ProductForOrder> productForOrders = new ArrayList<>();


    @ManyToMany
    private List<SpecValue> specValues = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();



}
