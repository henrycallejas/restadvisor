package online.restadvidor.restadvidor.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "restaurantUser", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	})
public class RestaurantUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    private String password;
    private String descriptionText;
    private String profilePic;
    private String firstName;
    private String lastname;
    //@OneToOne
    //@JoinColumn(name="rolId")
    private long rolId;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
    

    public RestaurantUser() {
		super();
	}
    

	public RestaurantUser(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public long getRolId() {
		return rolId;
	}


	public void setRolId(long rolId) {
		this.rolId = rolId;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
    
}
