package dmytro.shop.dto.response;

import dmytro.shop.entiti.SubCategories;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubCategoriesResponse {

    private Long id;

    private String name;

    public SubCategoriesResponse(SubCategories subCategories) {
        id = subCategories.getId();
        name = subCategories.getName();
    }
}
