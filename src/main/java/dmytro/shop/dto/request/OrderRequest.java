package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class OrderRequest {

    @NonNull
    private Long id;

    private List<Long> productsId;

    private Long userId;

}
