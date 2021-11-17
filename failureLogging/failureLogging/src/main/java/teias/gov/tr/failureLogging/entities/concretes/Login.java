package teias.gov.tr.failureLogging.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@Table(name="login")

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","userLogin","managerLogin"})
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private int loginId;
	
	@Column(name="e_mail")
	@Email
	@NotBlank
	@NotNull
	private String email;
		
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id",nullable = true)
    private User userLogin;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "manager_id",nullable = true)
    private Manager managerLogin;
	
	
	
	public Login() {
		super();
	}



	public Login(int loginId, @Email @NotBlank String email, String password, User userLogin, Manager managerLogin) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.password = password;
		this.userLogin = userLogin;
		this.managerLogin = managerLogin;
	}



	public int getLoginId() {
		return loginId;
	}



	public void setLoginId(int loginId) {
		this.loginId = loginId;
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



	public User getUserLogin() {
		return userLogin;
	}



	public void setUserLogin(User userLogin) {
		this.userLogin = userLogin;
	}



	public Manager getManagerLogin() {
		return managerLogin;
	}



	public void setManagerLogin(Manager managerLogin) {
		this.managerLogin = managerLogin;
	}
	
}