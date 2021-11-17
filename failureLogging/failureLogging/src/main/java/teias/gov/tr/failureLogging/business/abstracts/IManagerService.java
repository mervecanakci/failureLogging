package teias.gov.tr.failureLogging.business.abstracts;

import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Manager;


public interface IManagerService {

DataResult<List<Manager>> getAll();
	
	Result add(Manager manager);
	
	DataResult<Manager> getByDueDate(String dueDate);
	
	DataResult<Manager> getByProcessStatus(String processStatus);
	
	Result deleteByManagerId(int managerId);
	
	Result  updateByProcessStatus(int managerId,String processStatusUpdate);
	
	Result  updateByDueDate(int managerId,String dueDateUpdate);
	
	
	
	
	
	
	
	
	
	
}
