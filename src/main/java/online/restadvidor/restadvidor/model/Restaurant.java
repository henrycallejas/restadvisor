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
@Table(name = "restaurant")

public class Restaurant {
    @Id
    private long restaurantId;
    private String restaurantName;
    private String phoneNumber;
    private String webpage;
    private boolean delivery;
    @OneToOne
    @JoinColumn(name="userId")
    private RestaurantUser userId;

}
