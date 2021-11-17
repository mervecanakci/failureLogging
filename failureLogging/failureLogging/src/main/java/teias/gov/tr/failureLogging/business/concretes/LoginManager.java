package teias.gov.tr.failureLogging.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.ILoginService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.ILoginDao;
import teias.gov.tr.failureLogging.entities.concretes.Login;
@Service
public class LoginManager implements ILoginService {

	private ILoginDao loginDao;
     
     @Autowired
 	public LoginManager(ILoginDao loginDao) {
 		this.loginDao = loginDao;
}
     
@Override
public DataResult<List<Login>> getAll() {
	
	return new SuccessDataResult<List<Login>>(this.loginDao.findAll(),"Login listed..");
}

@Override
public Result add(Login login) {
	this.loginDao.save(login);
	return new SuccessResult("Login added..");
}

@Override
public DataResult<Login> getByPassword(String password) {
	return new SuccessDataResult<Login>(this.loginDao.getByPassword(password),"Password listed..");
}

@Override
public DataResult<Login> getByEmail(String email) {
	return new SuccessDataResult<Login>(this.loginDao.getByEmail(email),"Email listed..");
}

@Override
public Result deleteByLoginId(int loginId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Result updateByEmail(int loginId, String emailUpdate) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Result updateByPassword(int loginId, String passwordUpdate) {
	// TODO Auto-generated method stub
	return null;
}
     
     
     
     
     
}