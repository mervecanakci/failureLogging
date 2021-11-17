package teias.gov.tr.failureLogging.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@Table(name="managerUser")

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user","manager"})

public class ManagerUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="managerUser_id")
	private int managerUserId;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public ManagerUser() {
		super();
	}

	public ManagerUser(Manager manager, User user) {
		super();
		this.manager = manager;
		this.user = user;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
