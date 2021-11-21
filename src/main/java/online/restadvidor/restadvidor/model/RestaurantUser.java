package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "restaurantUser")

public class RestaurantUser {

    private long userId;
    private String username;
    private String userpass;
    private String descriptionText;
    private String profilePic;
    private String firstName;
    private String lastname;
    private int rolId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public RestaurantUser(long userId, String username, String userpass, String descriptionText, String profilePic, String firstName, String lastname, int rolId) {
        this.userId = userId;
        this.username = username;
        this.userpass = userpass;
        this.descriptionText = descriptionText;
        this.profilePic = profilePic;
        this.firstName = firstName;
        this.lastname = lastname;
        this.rolId = rolId;
    }
}
