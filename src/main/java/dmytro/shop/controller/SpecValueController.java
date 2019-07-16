package dmytro.shop.controller;

import dmytro.shop.dto.request.SpecValueRequest;
import dmytro.shop.dto.response.SpecValueResponse;
import dmytro.shop.entiti.SpecValue;
import dmytro.shop.service.SpecValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/specValue")
public class SpecValueController {
    @Autowired
    private SpecValueService specValueService;

    @PostMapping
    public SpecValueResponse save (@RequestBody SpecValueRequest specValueRequest) {
        return (SpecValueResponse) specValueService.save(specValueRequest);
    }
    @GetMapping
    public List<SpecValueResponse> findAll(){ return specValueService.findAll(); }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        specValueService.delete(id);
    }

    @PutMapping
    public SpecValueResponse update(@RequestParam Long id, @RequestBody SpecValueRequest specValueRequest) {
        return specValueService.update(specValueRequest, id);
    }

}
