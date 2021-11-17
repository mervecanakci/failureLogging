package teias.gov.tr.failureLogging.entities.concretes;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

@Table(name="manager")

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","managerFault","managerUser","managerLogin"})
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manager_id")
	private int managerId;
	
	@Column(name="due_date")
	private String dueDate;
	
	@Column(name="process_status")
	private String processStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	List<ManagerFault> managerFault;
	
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	List<ManagerUser> managerUser;
	
	@JsonIgnore
	@OneToOne(
			fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "managerLogin")
	private Login managerLogin;
	
	public Manager() {
		super();
	}

	public Manager(int managerId, String dueDate, String processStatus, List<ManagerFault> managerFault,
			List<ManagerUser> managerUser, Login managerLogin) {
		super();
		this.managerId = managerId;
		this.dueDate = dueDate;
		this.processStatus = processStatus;
		this.managerFault = managerFault;
		this.managerUser = managerUser;
		this.managerLogin = managerLogin;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public List<ManagerFault> getManagerFault() {
		return managerFault;
	}

	public void setManagerFault(List<ManagerFault> managerFault) {
		this.managerFault = managerFault;
	}

	public List<ManagerUser> getManagerUser() {
		return managerUser;
	}

	public void setManagerUser(List<ManagerUser> managerUser) {
		this.managerUser = managerUser;
	}

	public Login getManagerLogin() {
		return managerLogin;
	}

	public void setManagerLogin(Login managerLogin) {
		this.managerLogin = managerLogin;
	}


}
