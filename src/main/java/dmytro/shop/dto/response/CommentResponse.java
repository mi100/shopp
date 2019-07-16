package dmytro.shop.dto.response;


import dmytro.shop.entiti.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;

@Getter @Setter
public class CommentResponse {
    private Long id;

    private String username;

    private String text;

    private LocalDateTime datePosted;

    private Boolean show;

    private ProductResponse productResponse;

    public CommentResponse(Comment comment) {

        id = comment.getId();
        username = comment.getUsername();
        text = comment.getText();
        datePosted = comment.getDateTime();
        show = comment.getHidden();
        productResponse = new ProductResponse(comment.getProduct());
    }
}
