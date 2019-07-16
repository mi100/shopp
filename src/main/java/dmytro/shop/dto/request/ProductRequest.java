package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Positive
    private Integer price;

    private String photo;

    private Integer quantitySold;

    private Integer balance;

    private Long subcategoryId;
}
