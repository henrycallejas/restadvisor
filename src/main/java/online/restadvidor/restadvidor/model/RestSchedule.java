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
@Table(name = "restSchedule")

public class RestSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;
    private String openHour;
    private String closeHour;
    //@OneToOne
    //@JoinColumn(name="workDayId")
    private long workDayId;
    
    @OneToOne
    @JoinColumn(name="restaurantId")
    private Restaurant restaurantId;
    
}