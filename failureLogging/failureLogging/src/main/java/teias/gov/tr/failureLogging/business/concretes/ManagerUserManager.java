package teias.gov.tr.failureLogging.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.IManagerUserService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.IManagerUserDao;
import teias.gov.tr.failureLogging.entities.concretes.ManagerUser;
@Service
public class ManagerUserManager implements IManagerUserService {

	private IManagerUserDao managerUserDao;
	
	@Autowired
	public ManagerUserManager(IManagerUserDao managerUserDao) {
		this.managerUserDao=managerUserDao;
	
	}

	@Override
	public DataResult<List<ManagerUser>> getAll() {
		return new SuccessDataResult<List<ManagerUser>>(this.managerUserDao.findAll(),"ManagerUser listed..");

	}

	@Override
	public Result add(ManagerUser managerUser) {
		return null;
	}
	
	
	
	
	
	
	
	
}
