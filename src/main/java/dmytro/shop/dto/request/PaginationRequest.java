package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter @Setter
public class PaginationRequest {

    @NonNull
    private Integer size;
    @NonNull
    private Integer page;

    private String fieldName;
    private Sort.Direction direction;

    public Pageable toPageable() {
        if (fieldName == null || direction == null) {
            return PageRequest.of(page, size);
        } else {
            return PageRequest.of(page, size, direction, fieldName);
        }
    }
}
