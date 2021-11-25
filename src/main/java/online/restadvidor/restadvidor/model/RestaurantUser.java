package online.restadvidor.restadvidor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurantUser")

public class RestaurantUser {
    @Id
    private long userId;
    private String username;
    private String email;
    private String userpass;
    private String descriptionText;
    private String profilePic;
    private String firstName;
    private String lastname;
    @OneToOne
    @JoinColumn(name="rolId")
    private Rol rolId;

}
