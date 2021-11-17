package teias.gov.tr.failureLogging.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@Table(name="fault")

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","managerFault","faultUser"})
public class Fault {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fault_id")
	private int faultId;
	
	@Column(name="fault_name")
	private String faultName;
	
	@Column(name="fault_details")
	private String faultDetails;
	
	@JsonIgnore
	@Column(name="registration_date_and_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "2000-01-01 00:00:00")
	private LocalDateTime  registrationDateAndTime  = LocalDateTime.now();

	
	@JsonIgnore
	@OneToMany(mappedBy = "faultUser")
	private List<User> faultUser;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fault")
	List<ManagerFault> managerFault;

	public Fault() {
		super();
	}

	public Fault(int faultId, String faultName, String faultDetails, LocalDateTime registrationDateAndTime,
			List<User> faultUser, List<ManagerFault> managerFault) {
		super();
		this.faultId = faultId;
		this.faultName = faultName;
		this.faultDetails = faultDetails;
		this.registrationDateAndTime = registrationDateAndTime;
		this.faultUser = faultUser;
		this.managerFault = managerFault;
	}

	public int getFaultId() {
		return faultId;
	}

	public void setFaultId(int faultId) {
		this.faultId = faultId;
	}

	public String getFaultName() {
		return faultName;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public String getFaultDetails() {
		return faultDetails;
	}

	public void setFaultDetails(String faultDetails) {
		this.faultDetails = faultDetails;
	}

	public LocalDateTime getRegistrationDateAndTime() {
		return registrationDateAndTime;
	}

	public void setRegistrationDateAndTime(LocalDateTime registrationDateAndTime) {
		this.registrationDateAndTime = registrationDateAndTime;
	}

	public List<User> getFaultUser() {
		return faultUser;
	}

	public void setFaultUser(List<User> faultUser) {
		this.faultUser = faultUser;
	}

	public List<ManagerFault> getManagerFault() {
		return managerFault;
	}

	public void setManagerFault(List<ManagerFault> managerFault) {
		this.managerFault = managerFault;
	}



}
