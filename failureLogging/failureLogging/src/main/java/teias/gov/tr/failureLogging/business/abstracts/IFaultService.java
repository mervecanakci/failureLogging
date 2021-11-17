package teias.gov.tr.failureLogging.business.abstracts;


import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Fault;




public interface IFaultService {

	
DataResult<List<Fault>> getAll();
	
	Result add(Fault fault);
	
	DataResult<Fault> getByFaultName(String faultName);
	
	DataResult<Fault> getByFaultDetails(String faultDetails);

	DataResult<Fault> getByFaultId(int faultId);

	Result deleteByFaultId(int faultId);
	
	Result  updateByFaultName(int faultId,String faultNameUpdate);
	
	Result  updateByFaultDetails(int faultId,String faultDetailsUpdate);
	

}
