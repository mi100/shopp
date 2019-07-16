package dmytro.shop.dto.response;

import dmytro.shop.entiti.SpecValue;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecValueResponse {

    private Long id;

    private String value;

    public SpecValueResponse(SpecValue specValue) {
        id = specValue.getId();
        value = specValue.getValue();
    }
}
