package teias.gov.tr.failureLogging.business.abstracts;

import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Login;



public interface ILoginService {
DataResult<List<Login>> getAll();
	
	Result add(Login login);
	
	DataResult<Login> getByPassword(String password);
	
	DataResult<Login> getByEmail(String email);
	
	Result deleteByLoginId(int loginId);
	
	Result  updateByEmail(int loginId,String emailUpdate);
	
	Result  updateByPassword(int loginId,String passwordUpdate);

}
