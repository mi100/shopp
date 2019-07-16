package dmytro.shop.service;

import dmytro.shop.dto.request.PaginationRequest;
import dmytro.shop.dto.request.ProductRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.ProductResponse;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.SubCategories;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.ProductRepository;
import dmytro.shop.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoriesService subCategoriesService;

    public ProductResponse save (ProductRequest productRequest) {
        return new ProductResponse(productRepository.save(productRequestToProduct(productRequest, null)));
    }
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
    public List<ProductResponse> countLike(Long id) {
        Product one = findOne(id);
        one.setCountLike(one.getCountLike() + 1);
        productRepository.save(one);
        return null;
    }




    public DataResponse<ProductResponse> findPage(PaginationRequest paginationRequest){
        Page<Product> page = productRepository.findAll(paginationRequest.toPageable());
        List<ProductResponse> collect = page.get().map(ProductResponse::new).collect(Collectors.toList());
        return new DataResponse<>(page.getTotalPages(), page.getTotalElements(), collect);
    }

    public ProductResponse update(ProductRequest productRequest, Long id){
        return new ProductResponse(productRepository.save(productRequestToProduct(productRequest, findOne(id))));
    }
    public void delete(Long id) {
        productRepository.delete(findOne(id));
    }

    public Product findOne(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    private Product productRequestToProduct(ProductRequest productRequest, Product product) {
        if ( product == null){
            product = new Product();
        }
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setPathToImg(productRequest.getPhoto());
        product.setQuantitySold(productRequest.getQuantitySold());
        product.setBalance(productRequest.getBalance());

        SubCategories subCategories = subCategoriesService.findOne(productRequest.getSubcategoryId());
        product.setSubCategories(subCategories);
        return product;
    }

    public DataResponse<ProductResponse> getPageByFilter(Integer minPrice, Integer maxPrice, String name, Integer size, Integer page, String fieldName, Sort.Direction direction) {
        Page<Product> all = productRepository.findAll(new ProductSpecification(name, minPrice, maxPrice),
                PageRequest.of(page, size , direction, fieldName)
                );
        List<ProductResponse> collect = all.get().map(ProductResponse::new).collect(Collectors.toList());
    return new DataResponse<>(all.getTotalPages(), all.getTotalElements(), collect);
    }


}
