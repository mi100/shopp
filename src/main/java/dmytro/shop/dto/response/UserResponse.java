package dmytro.shop.dto.response;

import dmytro.shop.entiti.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class UserResponse {
    private Long id;

    private String login;

    private Integer phoneNumber;

    private Date age;

    private Boolean active;

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private Integer house;

    private Integer apartment;

    public UserResponse (User user){
        id = user.getId();
        login = user.getLogin();
        phoneNumber = user.getPhoneNumber();
        age = user.getAge();
        active = user.getActive();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        city = user.getCity();
        street = user.getStreet();
        house = user.getHouse();
        apartment = user.getApartment();
    }
}
