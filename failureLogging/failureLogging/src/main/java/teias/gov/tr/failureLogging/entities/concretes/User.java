package teias.gov.tr.failureLogging.entities.concretes;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@Table(name="users")

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","faultUser","managerUser","userlogin"})

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "fault_id")
	private Fault faultUser;
    
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<ManagerUser> managerUser;

	@JsonIgnore
	@OneToOne(
			fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "userLogin")
	private Login userLogin;
	
	public User() {
		super();
	}

	public User(int userId, String firstName, String lastName, Fault faultUser, List<ManagerUser> managerUser,
			Login userLogin) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.faultUser = faultUser;
		this.managerUser = managerUser;
		this.userLogin = userLogin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Fault getFaultUser() {
		return faultUser;
	}

	public void setFaultUser(Fault faultUser) {
		this.faultUser = faultUser;
	}

	public List<ManagerUser> getManagerUser() {
		return managerUser;
	}

	public void setManagerUser(List<ManagerUser> managerUser) {
		this.managerUser = managerUser;
	}

	public Login getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Login userLogin) {
		this.userLogin = userLogin;
	}

}