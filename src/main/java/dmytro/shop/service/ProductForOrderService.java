package dmytro.shop.service;

import dmytro.shop.dto.request.PaginationRequest;
import dmytro.shop.dto.request.ProductForOrderRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.ProductForOrderResponse;
import dmytro.shop.entiti.Order;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.ProductForOrder;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.ProductForOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductForOrderService {
    @Autowired
    private ProductForOrderRepository productForOrderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;


    public ProductForOrderResponse save (ProductForOrderRequest productForOrderRequest) {
        return new ProductForOrderResponse(productForOrderRepository.save(productForOrderRequestToProductForOrder(productForOrderRequest, null)));
    }
    public List<ProductForOrderResponse> findAll() {
        return productForOrderRepository.findAll().stream()
                .map(ProductForOrderResponse::new)
                .collect(Collectors.toList());
    }
    public DataResponse<ProductForOrderResponse> findPage(PaginationRequest paginationRequest){
        Page<ProductForOrder> page = productForOrderRepository.findAll(paginationRequest.toPageable());
        List<ProductForOrderResponse> collect = page.get().map(ProductForOrderResponse::new).collect(Collectors.toList());
        return new DataResponse<>(page.getTotalPages(), page.getTotalElements(), collect);
    }

    public ProductForOrderResponse update(ProductForOrderRequest productForOrderRequest, Long id){
        return new ProductForOrderResponse(productForOrderRepository.save(productForOrderRequestToProductForOrder(productForOrderRequest, findOne(id))));
    }
    public void delete(Long id) {
        productForOrderRepository.delete(findOne(id));
    }

    public ProductForOrder findOne(Long id) {
        return productForOrderRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    private ProductForOrder productForOrderRequestToProductForOrder(ProductForOrderRequest productForOrderRequest, ProductForOrder productForOrder) {
        if ( productForOrder == null){
            productForOrder = new ProductForOrder();
        }
        productForOrder.setCount(productForOrderRequest.getCount());

        Order order = orderService.findOne(productForOrderRequest.getOrderId());
        Product product = productService.findOne(productForOrderRequest.getProductsId());

        productForOrder.setOrder(order);
        productForOrder.setProduct(product);
        return productForOrder;
    }

//    public DataResponse<ProductForOrderResponse> getPageByFilter(Integer minPrice, Integer maxPrice, String name, Integer size, Integer page, String fieldName, Sort.Direction direction) {
//        Page<ProductForOrder> all = productForOrderRepository.findAll(new ProductForOrderSpecification(name, minPrice, maxPrice),
//                PageRequest.of(page, size , direction, fieldName)
//        );
//        List<ProductForOrderResponse> collect = all.get().map(ProductForOrderResponse::new).collect(Collectors.toList());
//        return new DataResponse<>(all.getTotalPages(), all.getTotalElements(), collect);
//    }

    private class ProductForOrderSpecification {
        public ProductForOrderSpecification(String name, Integer minPrice, Integer maxPrice) {
        }
    }
}
