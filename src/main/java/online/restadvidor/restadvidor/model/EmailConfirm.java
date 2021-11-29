package online.restadvidor.restadvidor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emailConfirm")
public class EmailConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmailConfirm;
	private String confirm;
	private boolean active=false;
	private long userId;
	
	
	public EmailConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public EmailConfirm(String confirm, boolean active, long userId) {
		super();
		this.confirm = confirm;
		this.active = active;
		this.userId = userId;
	}
	
	public long getIdEmailConfirm() {
		return idEmailConfirm;
	}
	public void setIdEmailConfirm(long idEmailConfirm) {
		this.idEmailConfirm = idEmailConfirm;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
