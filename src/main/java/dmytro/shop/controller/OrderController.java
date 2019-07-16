package dmytro.shop.controller;

import dmytro.shop.dto.request.OrderRequest;
import dmytro.shop.dto.request.ProductRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.OrderResponse;
import dmytro.shop.dto.response.ProductResponse;
import dmytro.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponse save (@RequestBody OrderRequest orderRequest) {
        return orderService.save(orderRequest);
    }

    @GetMapping
    public List<OrderResponse> findAll(){ return orderService.findAll(); }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        orderService.delete(id);
    }

    @PutMapping
    public OrderResponse update(@RequestParam Long id, @RequestBody OrderRequest orderRequest) {
        return orderService.update(orderRequest, id);
    }
//    @GetMapping("/filter")
//    public DataResponse<OrderResponse> filter(@RequestParam(required = false) String name,
//                                                        @RequestParam(required = false) Integer minPrice,
//                                                        @RequestParam(required = false) Integer maxPrice,
//                                                        @RequestParam Integer page,
//                                                        @RequestParam Integer size,
//                                                        @RequestParam String fieldName,
//                                                        @RequestParam Sort.Direction direction) {
//        return orderService.getPageByFilter(minPrice, maxPrice, name, page, size, fieldName, direction);
//    }
}
