package teias.gov.tr.failureLogging.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.IManagerFaultService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.IManagerFaultDao;
import teias.gov.tr.failureLogging.entities.concretes.ManagerFault;


@Service
public class ManagerFaultManager implements IManagerFaultService {

	
	private IManagerFaultDao managerFaultDao;
	
	@Autowired
	public ManagerFaultManager(IManagerFaultDao managerFaultDao) {
		this.managerFaultDao=managerFaultDao;
	
}

	@Override
	public DataResult<List<ManagerFault>> getAll() {
		return new SuccessDataResult<List<ManagerFault>>(this.managerFaultDao.findAll(),"Manager Fault listed..");

	}

	@Override
	public Result add(ManagerFault managerFault) {
		return null;
	}
}