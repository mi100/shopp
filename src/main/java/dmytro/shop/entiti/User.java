package dmytro.shop.entiti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Setter
@Getter
@NoArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable =  false)
    private String login;

    @Column(unique = true, nullable =  false)
    private Integer phoneNumber;

    private Date age;

    private Boolean active;

    @Column(unique = true, nullable =  false)
    private String firstName;

    @Column(unique = true, nullable =  false)
    private String lastName;

    @Column(unique = true, nullable =  false)
    private String city;

    @Column(unique = true, nullable =  false)
    private String street;

    @Column(unique = true, nullable =  false)
    private Integer house;

    @Column(unique = true, nullable =  false)
    private Integer apartment;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

}
