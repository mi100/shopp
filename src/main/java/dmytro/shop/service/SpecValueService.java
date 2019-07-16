package dmytro.shop.service;

import dmytro.shop.dto.request.SpecValueRequest;
import dmytro.shop.dto.response.SpecValueResponse;
import dmytro.shop.entiti.Product;
import dmytro.shop.entiti.SpecValue;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.SpecValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecValueService {
    @Autowired
    private SpecValueRepository specValueRepository;

    public SpecValueResponse save (SpecValueRequest specValueRequest) {
        return new SpecValueResponse(specValueRepository.save(specValueRequestToSpecValue(specValueRequest, null)));
    }
    public List<SpecValueResponse> findAll() {
        return specValueRepository.findAll().stream()
                .map(SpecValueResponse::new)
                .collect(Collectors.toList());
    }
    public SpecValue findOne(Long id) {
        return specValueRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    public void delete(Long id) {
        specValueRepository.delete(findOne(id));
    }

    public SpecValueResponse update(SpecValueRequest specValueRequest, Long id){
        return new SpecValueResponse(specValueRepository.save(specValueRequestToSpecValue(specValueRequest, findOne(id))));
    }
    private SpecValue specValueRequestToSpecValue(SpecValueRequest specValueRequest, SpecValue specValue) {
        if ( specValue == null){
            specValue = new SpecValue();
            specValue = specValueRepository.save(specValue);
        }
        specValue.setValue(specValueRequest.getValue());

        return specValue;
    }
}
