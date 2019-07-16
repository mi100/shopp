package dmytro.shop;


import dmytro.shop.dto.request.SubCategoriesRequest;
import dmytro.shop.entiti.Category;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.SubCategories;
import dmytro.shop.repository.CategoryRepository;
import dmytro.shop.repository.ProductRepository;
import dmytro.shop.repository.SubCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
