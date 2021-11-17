package teias.gov.tr.failureLogging.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import teias.gov.tr.failureLogging.business.abstracts.IFaultService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.ErrorDataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Fault;

@RestController
@RequestMapping("/api/fault")
public class FaultController {

	private IFaultService faultService;

	@Autowired
	public FaultController(IFaultService faultService ) {
		super();
		this.faultService=faultService;
	}

	@GetMapping("/getall")
	public DataResult<List<Fault>> getAll(){
		return this.faultService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Fault fault) {	
		return ResponseEntity.ok(this.faultService.add(fault));

	}
	@DeleteMapping("/deleteByFaultId/{faultId}")
	public Result deleteByFaultId(@RequestParam(value = "faultId") int faultId) {
		return this.faultService.deleteByFaultId(faultId);
	}
	
	@PutMapping("/updateByFaultName/{faultId}")
	public Result updateByFaultName(@RequestParam(value = "faultId") int faultId,@RequestParam(value = "genderUpdate") String faultNameUpdate) {
		return this.faultService.updateByFaultName(faultId, faultNameUpdate);
	}
	@PutMapping("/updateByFaultDetails/{faultId}")
	public Result updateByFaultDetails(@RequestParam(value = "faultId") int faultId,@RequestParam(value = "faultDetailsUpdate") String faultDetailsUpdate) {
		return this.faultService.updateByFaultDetails(faultId, faultDetailsUpdate);
	}
	
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseStatus(HttpStatus.BAD_REQUEST)

	public ErrorDataResult<Object>handleValidationException
	(MethodArgumentNotValidException exceptions) {
		
		Map<String, String> validationErrors=new HashMap<String, String>();

		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	} 

		ErrorDataResult<Object>errors=new 
		ErrorDataResult<Object>(validationErrors, "doğrulama hataları");
		return errors;	

	}	
	

}
