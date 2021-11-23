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
@Table(name = "branchOffice")
public class BranchOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String address;
    private String department;
    private String municipality;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "restaurantId")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne
    @JoinColumn(name="restaurantId")
    private Restaurant restaurantId;
}
