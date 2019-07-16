package dmytro.shop.dto.response;

import dmytro.shop.entiti.Spec;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecResponse {

    private Long id;

    private String name;

    public SpecResponse(Spec spec) {
        id = spec.getId();
        name = spec.getName();
    }
}
