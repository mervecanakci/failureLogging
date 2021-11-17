package teias.gov.tr.failureLogging.core.utilites.result;



public class ErrorResult extends Result{
	
	public ErrorResult() {
		super(false);
	}
	
	public ErrorResult(String message) {
		super(false,message);
	}

}
