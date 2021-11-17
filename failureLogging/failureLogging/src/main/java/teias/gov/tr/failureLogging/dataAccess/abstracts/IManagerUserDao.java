package teias.gov.tr.failureLogging.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import teias.gov.tr.failureLogging.entities.concretes.ManagerUser;



public interface IManagerUserDao extends JpaRepository<ManagerUser , Integer>{

	
	
}
