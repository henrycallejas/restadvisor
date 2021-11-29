package online.restadvidor.restadvidor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;
    private String restaurantName;
    private String phoneNumber;
    private String webpage;
    private boolean delivery;
    //@OneToOne
    //@JoinColumn(name="userId")
    private long userId;
    

}
