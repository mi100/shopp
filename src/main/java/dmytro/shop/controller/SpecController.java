package dmytro.shop.controller;

import dmytro.shop.dto.request.SpecRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.SpecResponse;
import dmytro.shop.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/spec")
public class SpecController {
    @Autowired
    private SpecService specService;

    @PostMapping
    public SpecResponse save (@RequestBody SpecRequest specRequest) {
        return (SpecResponse) specService.save(specRequest);
    }
    @GetMapping
    public List<SpecResponse> findAll(){ return specService.findAll(); }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        specService.delete(id);
    }

    @PutMapping
    public SpecResponse update(@RequestParam Long id, @RequestBody SpecRequest specRequest) {
        return specService.update(specRequest, id);
    }
}
