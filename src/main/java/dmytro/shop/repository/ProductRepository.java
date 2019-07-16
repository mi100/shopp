package dmytro.shop.repository;

import dmytro.shop.entiti.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("from Product  p where p.price between :start and :to")
    List<Product> findAllPrice(@Param("to") Integer to, @Param("start") Integer from);

    @Query("from Product  p join p.subCategories as c where c.name=:name")
    List<Product> findAllBySubCategoriesName(@Param("name") String name);

    @Query("from Product p join p.specValues as c where c.value=:value")
    List<Product> findAllBySpecValues(@Param("value") String value);

    Optional<Product> findByName(String name);
    List<Product> findByNameLikeAndPriceLessThanEqual(String name, Integer maxPrice);
}
