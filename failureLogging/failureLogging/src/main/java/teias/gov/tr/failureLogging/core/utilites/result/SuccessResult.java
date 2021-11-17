package teias.gov.tr.failureLogging.core.utilites.result;



public class SuccessResult extends Result{
	
	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String message) {
		super(true,message);
	}
}
