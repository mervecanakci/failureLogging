package teias.gov.tr.failureLogging.business.abstracts;

import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.User;



public interface IUserService {

DataResult<List<User>> getAll();
	
	Result add(User user);
	
	DataResult<User> getByFirstName(String firstName);
	
	DataResult<User> getByLastName(String lastName);
	
    Result deleteByUserId(int userId);
	
	Result  updateByFirstName(int userId,String firstNameUpdate);
	
	Result  updateByLastName(int userId,String lastNameUpdate);
	
}
