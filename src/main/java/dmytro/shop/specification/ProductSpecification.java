package dmytro.shop.specification;

import dmytro.shop.entiti.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.text.NumberFormat.Field.PERCENT;

public class ProductSpecification implements Specification<Product> {

    private String name;

    private Integer minPrice;

    private Integer maxPrice;

    public ProductSpecification(String name, Integer minPrice, Integer maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    //    @Override
//    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        List<Predicate> predicates = new ArrayList<>();

//        predicates.add(byName(root, criteriaBuilder));
//        predicates.add(byPrice(root, criteriaBuilder));
//
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//    private Predicate byName(Root<Product> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("name"), "%" + name + "%");
//    }
//    private Predicate byPrice (Root<Product> root, CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
//    }



    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(findByNameLike(root, criteriaBuilder));
        predicates.add(findByPrice(root, criteriaBuilder));
        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }

    private Predicate findByNameLike(Root<Product> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (name == null || name.isEmpty()) {
            predicate = cb.conjunction();
        } else {
            predicate = cb.like(r.get("name"), "%" + name + "%");
        }
        return predicate;
    }

    private Predicate findByPrice(Root<Product> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (maxPrice == null && minPrice == null) {
            predicate = cb.conjunction();
        } else if (maxPrice == null) {
            predicate = cb.greaterThanOrEqualTo(r.get("price"), minPrice);
        } else if (minPrice == null) {
            predicate = cb.lessThanOrEqualTo(r.get("price"), maxPrice);
        } else {
            predicate = cb.between(r.get("price"), minPrice, maxPrice);
        }
        return predicate;
    }
}
