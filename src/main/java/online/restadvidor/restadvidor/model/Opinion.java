package online.restadvidor.restadvidor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
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
    //@OneToOne
    //@JoinColumn(name="userId")
    private long userId;
    //@OneToOne
    //@JoinColumn(name="branchId")
    private long branchId;

}
