package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class SubCategoriesRequest {

    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @NotNull
    private Long categoryId;
}
