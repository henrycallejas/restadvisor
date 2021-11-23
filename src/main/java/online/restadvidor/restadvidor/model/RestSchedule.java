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
@Table(name = "restSchedule")

public class RestSchedule {
    @Id
    private long scheduleId;
    private String openHour;
    private String closeHour;
    @OneToOne
    @JoinColumn(name="workDayId")
    private WorkDay workDayId;

}