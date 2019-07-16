package dmytro.shop.service;

import dmytro.shop.dto.request.SpecRequest;
import dmytro.shop.dto.response.SpecResponse;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.Spec;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.SpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecService {
    @Autowired
    private SpecRepository specRepository;

    public SpecRepository save (SpecRequest specRequest) {
        return (SpecRepository) new SpecResponse(specRepository.save(specRequestToSpec(specRequest, null)));
    }
    public List<SpecResponse> findAll() {
        return specRepository.findAll().stream()
                .map(SpecResponse::new)
                .collect(Collectors.toList());
    }
    public void delete(Long id) {
        specRepository.delete(findOne(id));
    }

    public Spec findOne(Long id) {
        return specRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    public SpecResponse update(SpecRequest specRequest, Long id){
        return new SpecResponse(specRepository.save(specRequestToSpec(specRequest, findOne(id))));
    }
    private Spec specRequestToSpec(SpecRequest specRequest, Spec spec) {
        if ( spec == null){
            spec = new Spec();
        }
        spec.setId(specRequest.getId());

        return spec;
    }
}
