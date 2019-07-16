package dmytro.shop.dto.response;


import dmytro.shop.entiti.ProductForOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ProductForOrderResponse {

    private Long id;

    private Integer count;

    private ProductResponse productResponse;


    public ProductForOrderResponse(ProductForOrder productForOrder) {
        id = productForOrder.getId();
        count = productForOrder.getCount();
        productResponse = new ProductResponse(productForOrder.getProduct());


    }

}
