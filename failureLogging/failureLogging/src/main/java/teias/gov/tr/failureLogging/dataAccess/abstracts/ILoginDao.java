package teias.gov.tr.failureLogging.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import teias.gov.tr.failureLogging.entities.concretes.Login;


public interface ILoginDao extends JpaRepository<Login, Integer>{
	Login getByLoginId(int loginId);
	Login getByPassword(String password);
	 Login getByEmail(String eMail);
	
	 @Transactional
	    @Modifying
	    @Query("DELETE From Login l where l.loginId=:loginId")
	    void deleteByLoginId(int loginId);
	 
	@Transactional
	    @Modifying
	    @Query("UPDATE Login l SET l.email=:emailUpdate WHERE l.loginId=:loginId")
	    void updateByEmail(int loginId,String emailUpdate);
	

	@Transactional
	    @Modifying
	    @Query("UPDATE Login l SET l.password=:passwordUpdate WHERE l.loginId=:loginId")
	    void updateByPassword(int loginId,String passwordUpdate);

	


	
	
	
	
	
	
}
