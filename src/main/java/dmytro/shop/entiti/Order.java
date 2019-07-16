package dmytro.shop.entiti;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table (name ="_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String status;               //статус

    private  Long orderNumber;            //номер замовлення

    private  Boolean delivery;            //доставка

    private  String sellerOrStore;       //продавець або магазин

    private  String typeofDelivery;       //тип доставки

    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    private User user;

    @OneToMany (mappedBy = "order")
    private List<ProductForOrder> productForOrders = new ArrayList<>();


    //    @ManyToMany
//    private List<Product> products = new ArrayList<>();



}
