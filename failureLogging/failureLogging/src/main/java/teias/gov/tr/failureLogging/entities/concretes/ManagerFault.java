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

@Table(name="managerFault")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fault","manager"})

public class ManagerFault {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="managerFault_id")
	private int managerFaultId;
	/*
	
	@JsonIgnore
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "user_role",
        joinColumns = { @JoinColumn(name = "email") },
        inverseJoinColumns = { @JoinColumn(name = "role_id") })
	*/
	
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
     private Manager manager;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fault_id")
     private Fault fault;

	public ManagerFault() {
		super();
	}

	public ManagerFault(Manager manager, Fault fault) {
		super();
		this.manager = manager;
		this.fault = fault;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

    
    
    
    
    
    
    
    
    
    
}
