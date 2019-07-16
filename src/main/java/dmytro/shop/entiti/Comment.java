package dmytro.shop.entiti;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    @Column(columnDefinition = "text")
    private String text;

    private LocalDateTime dateTime;

    private Boolean hidden;

    @ManyToOne
    private Product product;


}
