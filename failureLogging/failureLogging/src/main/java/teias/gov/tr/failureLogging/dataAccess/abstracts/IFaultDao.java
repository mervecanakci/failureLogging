package teias.gov.tr.failureLogging.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import teias.gov.tr.failureLogging.entities.concretes.Fault;

public interface IFaultDao extends JpaRepository<Fault, Integer>{
	Fault getByFaultId(int faultId);
	Fault getByFaultDetails(String faultDetails);

	Fault getByFaultName(String faultName);
	
	@Transactional
    @Modifying
    @Query("DELETE From Fault f where f.faultId=:faultId")
    void deleteByFaultId(int faultId);
 
@Transactional
    @Modifying
    @Query("UPDATE Fault f SET f.faultName=:faultNameUpdate WHERE f.faultId=:faultId")
    void updateByFaultName(int faultId,String faultNameUpdate);


@Transactional
    @Modifying
    @Query("UPDATE Fault f SET f.faultDetails=:faultDetailsUpdate WHERE f.faultId=:faultId")
    void updateByFaultDetails(int faultId,String faultDetailsUpdate);
/*	
@Transactional
@Modifying
@Query("UPDATE Fault f SET f.registrationDateAndTime=:registrationDateAndTimeUpdate WHERE f.faultId=:faultId")
void updateByRegistrationDateAndTime(int faultId,String registrationDateAndTimeUpdate);

*/


//Fault getByRegistrationDateAndTime(String registrationDateAndTime);
}
