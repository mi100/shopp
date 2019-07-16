package dmytro.shop.dto.response;

import dmytro.shop.entiti.Order;
import dmytro.shop.entiti.ProductForOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class OrderResponse {

    private Long id;

    private  String status;

    private  Long orderNumber;

    private  Boolean delivery;

    private  String sellerOrStore;

    private  String typeofDelivery;

    private LocalDateTime date = LocalDateTime.now();

    private UserResponse userResponse;

    private List<ProductForOrderResponse> productForOrderResponses;

    public OrderResponse(Order order) {
     id = order.getId();
     status = order.getStatus();
     orderNumber = order.getOrderNumber();
     delivery = order.getDelivery();
     sellerOrStore = order.getSellerOrStore();
     typeofDelivery = order.getTypeofDelivery();
     date = order.getDate();
     userResponse = new UserResponse(order.getUser());
     productForOrderResponses = order.getProductForOrders()
             .stream().map(ProductForOrderResponse::new)
             .collect(Collectors.toList());

    }



//    public OrderResponse(Order order) {
//        productForOrderResponses = order . getProductForOrders().stream()
//                .map((ProductForOrder id1) -> new ProductForOrderResponse(id1)).collect(Collectors.toList());
//    }//////?????????це буде працювати
}

