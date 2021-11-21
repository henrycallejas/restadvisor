package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "restSchedule")

public class RestSchedule {

    private long scheduleId;
    private String openHour;
    private String closeHour;
    private int workDayId;

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public int getWorkDayId() {
        return workDayId;
    }

    public void setWorkDayId(int workDayId) {
        this.workDayId = workDayId;
    }

    public RestSchedule(long scheduleId, String openHour, String closeHour, int workDayId) {
        this.scheduleId = scheduleId;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.workDayId = workDayId;
    }
}