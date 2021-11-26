package online.restadvidor.restadvidor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "branchOffice")
public class BranchOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String address;
    private String department;
    private String municipality;


    //@OneToOne
    //@JoinColumn(name="restaurantId")
    private long restaurantId;
    
    
}
