package dmytro.shop.controller;

import dmytro.shop.dto.request.SubCategoriesRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.SubCategoriesResponse;
import dmytro.shop.entiti.SubCategories;
import dmytro.shop.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subCategories")
public class SubCategoriesController {
    @Autowired
    private SubCategoriesService subCategoriesService;

    @PostMapping
    public SubCategoriesResponse save (@Valid @RequestBody SubCategoriesRequest subCategoriesRequest) {
        return (SubCategoriesResponse) subCategoriesService.save(subCategoriesRequest);
    }
    @GetMapping
    public List<SubCategoriesResponse> findAll(){ return (List<SubCategoriesResponse>) subCategoriesService.findAll(); }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        subCategoriesService.delete(id);
    }

    @PutMapping
    public SubCategoriesResponse update(@RequestParam Long id, @RequestBody SubCategoriesRequest subCategoriesRequest) {
        return subCategoriesService.update(subCategoriesRequest, id);
    }
}
