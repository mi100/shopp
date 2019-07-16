package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SpecRequest {

    @NotBlank
    @Size(min = 6, max = 30)
    private String name;

    private List<Long> subCategoryId;

    private Long Id;
}
