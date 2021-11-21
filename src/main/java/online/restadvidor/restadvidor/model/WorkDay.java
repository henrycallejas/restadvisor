package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "workDay")

public class WorkDay {

    private long workDayId;
    private String dayName;

    public long getWorkDayId() {
        return workDayId;
    }

    public void setWorkDayId(long workDayId) {
        this.workDayId = workDayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public WorkDay(long workDayId, String dayName) {
        this.workDayId = workDayId;
        this.dayName = dayName;
    }
}
