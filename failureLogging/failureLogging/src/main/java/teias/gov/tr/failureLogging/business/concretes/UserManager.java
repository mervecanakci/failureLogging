package teias.gov.tr.failureLogging.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.IUserService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.IUserDao;
import teias.gov.tr.failureLogging.entities.concretes.User;

@Service
public class UserManager implements IUserService {

	 private IUserDao userDao;
	 
	 @Autowired
	 public UserManager(IUserDao userDao) {
		 this.userDao= userDao;
	 }

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User listed..");

	}

	@Override
	public Result add(User user) {	
		return null;
	}

	@Override
	public DataResult<User> getByFirstName(String firstName) {
		return new SuccessDataResult<User>(this.userDao.getByFirstName(firstName),"first Name listed..");

	}

	@Override
	public DataResult<User> getByLastName(String lastName) {
		return new SuccessDataResult<User>(this.userDao.getByLastName(lastName),"last Name listed..");

	}

	@Override
	public Result deleteByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByFirstName(int userId, String firstNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByLastName(int userId, String lastNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	 

	
	
	
	
	
	
	
}
