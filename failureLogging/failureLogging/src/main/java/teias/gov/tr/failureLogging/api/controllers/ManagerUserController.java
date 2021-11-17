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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import teias.gov.tr.failureLogging.business.abstracts.IManagerUserService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.ErrorDataResult;
import teias.gov.tr.failureLogging.entities.concretes.ManagerUser;

@RestController
@RequestMapping("/api/managerUser")
public class ManagerUserController {

private IManagerUserService managerUserService;
	
	@Autowired
	public ManagerUserController(IManagerUserService managerUserService) {
		super();
		this.managerUserService = managerUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ManagerUser>> getAll(){
		return this.managerUserService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody ManagerUser managerUser) {	
		return ResponseEntity.ok(this.managerUserService.add(managerUser));
	
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
