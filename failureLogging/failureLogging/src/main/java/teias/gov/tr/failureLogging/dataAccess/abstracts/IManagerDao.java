package teias.gov.tr.failureLogging.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import teias.gov.tr.failureLogging.entities.concretes.Manager;



public interface IManagerDao extends JpaRepository<Manager, Integer> {

	Manager getByDueDate(String dueDate);

	Manager getByProcessStatus(String processStatus);
	
   Manager getByManagerId(int managerId);
	
	@Transactional
    @Modifying
    @Query("DELETE From Manager m where m.managerId=:managerId")
    void deleteByManagerId(int managerId);
	
@Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.processStatus=:processStatusUpdate WHERE m.managerId=:managerId")
    void updateByProcessStatus(int managerId,String processStatusUpdate);
	
@Transactional
@Modifying
@Query("UPDATE Manager m SET m.dueDate=:dueDateUpdate WHERE m.managerId=:managerId")
void updateByDueDate(int managerId,String dueDateUpdate);


	
	
	
	
	
}
