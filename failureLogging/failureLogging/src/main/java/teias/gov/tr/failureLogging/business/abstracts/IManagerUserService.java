package teias.gov.tr.failureLogging.business.abstracts;

import java.util.List;

import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.ManagerUser;

public interface IManagerUserService {
DataResult<List<ManagerUser>>getAll();
Result add(ManagerUser managerUser);
}
