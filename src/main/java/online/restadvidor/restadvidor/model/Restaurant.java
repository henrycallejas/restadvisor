package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "restaurant")

public class Restaurant {

    private long restaurantId;
    private String restaurantName;
    private String phoneNumber;
    private String webpage;
    private boolean delivery;
    private int userId;

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Restaurant(long restaurantId, String restaurantName, String phoneNumber, String webpage, boolean delivery, int userId) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.phoneNumber = phoneNumber;
        this.webpage = webpage;
        this.delivery = delivery;
        this.userId = userId;
    }
}
