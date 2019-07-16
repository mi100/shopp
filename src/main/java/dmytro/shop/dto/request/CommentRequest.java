package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class CommentRequest {

    @NonNull
    private String username;

    @NonNull
    private String text;

    @NonNull
    private Long productId;

    private Boolean show;
}
