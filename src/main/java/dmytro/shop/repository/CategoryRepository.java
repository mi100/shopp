package dmytro.shop.repository;

import dmytro.shop.entiti.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query ("from Category c where c.name like ?1")
    List<Category> fbnlike(String name);

}
