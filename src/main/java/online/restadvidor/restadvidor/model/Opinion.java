package online.restadvidor.restadvidor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long opinionId;
    private String tittle;
    private String commentText;
    private Date publishDate;
    private BigDecimal score;
    @OneToOne
    @JoinColumn(name="userId")
    private RestaurantUser userId;
    @OneToOne
    @JoinColumn(name="branchId")
    private BranchOffice branchId;

}
