package dmytro.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DataResponse<T> {

    private Integer totalPages;

    private Long total;

    private List<T> data;

    public DataResponse(Integer totalPages, Long total, List<T> data) {
        this.totalPages = totalPages;
        this.total = total;
        this.data = data;
    }
}

