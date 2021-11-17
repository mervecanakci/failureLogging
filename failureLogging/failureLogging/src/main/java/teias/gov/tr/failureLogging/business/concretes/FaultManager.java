package teias.gov.tr.failureLogging.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teias.gov.tr.failureLogging.business.abstracts.IFaultService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessDataResult;
import teias.gov.tr.failureLogging.core.utilites.result.SuccessResult;
import teias.gov.tr.failureLogging.dataAccess.abstracts.IFaultDao;
import teias.gov.tr.failureLogging.entities.concretes.Fault;


@Service
public class FaultManager implements IFaultService {

	private IFaultDao faultDao;
	
	@Autowired
	public  FaultManager(IFaultDao faultDao) {
		this.faultDao=faultDao;
	}

	@Override
	public DataResult<List<Fault>> getAll() {
		return new SuccessDataResult<List<Fault>>(this.faultDao.findAll(),"Fault listed..");

	}
 
	@Override
	public Result add(Fault fault) {
		this.faultDao.save(fault);
		return new SuccessResult("Fault added..");
	}

	@Override
	public DataResult<Fault> getByFaultName(String faultName) {
		return new SuccessDataResult<Fault>
		(this.faultDao.getByFaultName(faultName),"FaultName listed..");
	}

	@Override
	public DataResult<Fault>getByFaultId(int faultId) {
		return new SuccessDataResult<Fault>
				(this.faultDao.getByFaultId(faultId));
	}
	
	@Override
	public DataResult<Fault> getByFaultDetails(String faultDetails) {
		return new SuccessDataResult<Fault>
		(this.faultDao.getByFaultDetails(faultDetails),"faultDetails listed..");
	}
	@Override
	public Result deleteByFaultId(int faultId) {

		return null;
	}
/*

@Override
public Result updateByFaultName(String faultName) {

	if(this.faultDao.getByFaultName(faultId) == false) {
		return new ErrorResult("Böyle bir arıza bulunmamaktadır..");
}
	*/

	@Override
	public Result updateByFaultName(int faultId, String faultNameUpdate) {
			return null;
	
	}

	@Override
	public Result updateByFaultDetails(int faultId, String faultDetailsUpdate) {
		return null;
	}

	}
	
 
 
 

