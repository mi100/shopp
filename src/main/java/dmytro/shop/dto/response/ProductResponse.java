package dmytro.shop.dto.response;

import dmytro.shop.entiti.Product;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResponse {

    private Long id;

    private String name;

    private  Integer price;

    private Integer quantitySold;

    private Integer balance;

    private SubCategoriesResponse subCategoriesResponse;

   public ProductResponse(Product product){
       id = product.getId();
       name = product.getName();
       price = product.getPrice();
       quantitySold = product.getQuantitySold();
       balance = product.getBalance();
       subCategoriesResponse = new SubCategoriesResponse(product.getSubCategories());
   }
}
