package dmytro.shop.controller;

import dmytro.shop.dto.request.PaginationRequest;
import dmytro.shop.dto.request.ProductRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.ProductResponse;
import dmytro.shop.entiti.Product;
import dmytro.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse save (@Valid @RequestBody ProductRequest productRequest) {
       return (ProductResponse) productService.save(productRequest);
    }

    @PutMapping("/page")
    public DataResponse<ProductResponse> findPage(@Valid @RequestBody PaginationRequest paginationRequest){
        return productService.findPage(paginationRequest);
    }

    @GetMapping("/filter")
    public DataResponse<ProductResponse> filter(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) Integer minPrice,
                                                @RequestParam(required = false) Integer maxPrice,
                                               @RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @RequestParam String fieldName,
                                               @RequestParam Sort.Direction direction) {
        return productService.getPageByFilter(minPrice, maxPrice, name, size, page, fieldName, direction);
    }

    @GetMapping
    public List<ProductResponse> findAll(){ return productService.findAll(); }


    @PutMapping
    public ProductResponse update(@RequestParam Long id,@Valid @RequestBody ProductRequest productRequest) {
        return productService.update(productRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        productService.delete(id);
    }

    @GetMapping("/countLike")
    public List<ProductResponse> countLike(@RequestParam Long id) {return productService.countLike(id);}
}
