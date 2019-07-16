package dmytro.shop.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    @Size(min = 6, max = 30)
    private String login;

    @NonNull
    @NotBlank
    @Size(min = 10, max = 13)
    private String phoneNumber;

    @NotBlank
    @Size(min = 6, max = 30)
    private Date age;

    private Boolean active;

    @NotBlank
    @Size(min = 6, max = 30)
    private String firstName;


    @NotBlank
    @Size(min = 6, max = 30)
    private String lastName;

    @NotBlank
    @Size(min = 6, max = 30)
    private String city;

    @NotBlank
    @Size(min = 6, max = 30)
    private String street;

    @NonNull
    @NotBlank
    @Size(min = 1, max = 4)
    private Integer house;

    @NonNull
    @NotBlank
    @Size(min = 1, max = 4)
    private Integer apartment;

}
