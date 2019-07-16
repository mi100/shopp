package dmytro.shop.service;

import dmytro.shop.dto.request.SubCategoriesRequest;
import dmytro.shop.dto.response.SubCategoriesResponse;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.SubCategories;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.SubCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoriesService {
    @Autowired
    private SubCategoriesRepository subCategoriesRepository;

    @Autowired
    private CategoryService categoryService;

    public SubCategoriesResponse save(SubCategoriesRequest subCategoriesRequest) {
        return new SubCategoriesResponse(subCategoriesRepository.save(subCategoriesRequestToSubCategory(subCategoriesRequest, null)));
    }

    public List<SubCategoriesResponse> findAll() {
        return subCategoriesRepository.findAll().stream()
                .map(SubCategoriesResponse::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        subCategoriesRepository.delete(findOne(id));
    }

    public SubCategories findOne(Long id) {
        return subCategoriesRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }

    public SubCategoriesResponse update(SubCategoriesRequest subCategoriesRequest, Long id) {
        return new SubCategoriesResponse(subCategoriesRepository.save(subCategoriesRequestToSubCategory(subCategoriesRequest, findOne(id))));
    }

    private SubCategories subCategoriesRequestToSubCategory(SubCategoriesRequest subCategoriesRequest, SubCategories subCategories) {
        if (subCategories == null) {
            subCategories = new SubCategories();
        }
        subCategories.setName(subCategoriesRequest.getName());
        subCategories.setCategory(categoryService.findOne(subCategoriesRequest.getCategoryId()));

        return subCategories;
    }
}
