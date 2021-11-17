package teias.gov.tr.failureLogging.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.IManagerService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.IManagerDao;
import teias.gov.tr.failureLogging.entities.concretes.Manager;

@Service
public class ManagerManager implements IManagerService {

	private IManagerDao managerDao;
    
    @Autowired
	public ManagerManager(IManagerDao managerDao) {
		this.managerDao = managerDao;
	
}

	@Override
	public DataResult<List<Manager>> getAll() {
		return new SuccessDataResult<List<Manager>>(this.managerDao.findAll(),"Manager listed..");

	}

	@Override
	public Result add(Manager manager) {
		return null;
	}

	@Override
	public DataResult<Manager> getByDueDate(String dueDate) {
		return new SuccessDataResult<Manager>(this.managerDao.getByDueDate(dueDate),"due Date listed..");

	}

	@Override
	public DataResult<Manager> getByProcessStatus(String processStatus) {
		return new SuccessDataResult<Manager>(this.managerDao.getByProcessStatus(processStatus),"process Status listed..");

	}

	@Override
	public Result deleteByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByProcessStatus(int managerId, String processStatusUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByDueDate(int managerId, String dueDateUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
}