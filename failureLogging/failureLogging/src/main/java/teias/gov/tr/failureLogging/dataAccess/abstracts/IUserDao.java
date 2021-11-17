package teias.gov.tr.failureLogging.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import teias.gov.tr.failureLogging.entities.concretes.User;


 public interface IUserDao extends JpaRepository<User, Integer> {
		User getByFirstName(String firstName);
		
		User getByUserId(int userId);
		
		User getByLastName(String lastName);
	
		@Transactional
	    @Modifying
	    @Query("DELETE From User u where u.userId=:userId")
	    void deleteByUserId(int userId);
		
	@Transactional
	    @Modifying
	    @Query("UPDATE User u SET u.firstName=:firstNameUpdate WHERE u.userId=:userId")
	    void updateByFirstName(int userId,String firstNameUpdate);
	 
	@Transactional
    @Modifying
    @Query("UPDATE User u SET u.lastName=:lastNameUpdate WHERE u.userId=:userId")
    void updateByLastName(int userId,String lastNameUpdate);



	 
}
