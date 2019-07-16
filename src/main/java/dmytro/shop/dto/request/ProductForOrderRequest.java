package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductForOrderRequest {

    @NonNull
    private Long id;

    private Integer count;

    private Long cartId;

    private Long productsId;

    private Long orderId;
}
