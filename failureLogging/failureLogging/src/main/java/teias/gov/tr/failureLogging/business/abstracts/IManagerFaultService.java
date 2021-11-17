package teias.gov.tr.failureLogging.business.abstracts;

import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.ManagerFault;


public interface IManagerFaultService {

	DataResult<List<ManagerFault>>getAll();
	Result add(ManagerFault managerFault);
	
	
	
	
	
	
	
	
}
