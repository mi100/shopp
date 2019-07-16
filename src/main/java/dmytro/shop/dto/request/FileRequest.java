package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class FileRequest {
    @NotBlank
    @NonNull
    private String data;

    private String fileName;
}
