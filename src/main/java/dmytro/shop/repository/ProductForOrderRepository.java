package dmytro.shop.repository;

import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.ProductForOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductForOrderRepository extends JpaRepository<ProductForOrder, Long> {

}
