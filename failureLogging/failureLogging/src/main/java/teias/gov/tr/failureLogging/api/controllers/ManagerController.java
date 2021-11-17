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

import teias.gov.tr.failureLogging.business.abstracts.IManagerService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.ErrorDataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Manager;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

	
	private IManagerService managerService;

	@Autowired
	public ManagerController(IManagerService managerService ) {
		super();
		this.managerService=managerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Manager>> getAll(){
		return this.managerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Manager manager) {	
		return ResponseEntity.ok(this.managerService.add(manager));

	}

	@DeleteMapping("/deleteByManagerId/{managerId}")
	public Result deleteByManagerId(@RequestParam(value = "managerId") int managerId) {
		return this.managerService.deleteByManagerId(managerId);
	}
	
	@PutMapping("/updateByProcessStatus/{managerId}")
	public Result updateByProcessStatus(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "processStatusUpdate") String processStatusUpdate) {
		return this.managerService.updateByProcessStatus(managerId, processStatusUpdate);
	}
	@PutMapping("/updateByDueDate/{managerId}")
	public Result updateByDueDate(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "dueDateUpdate") String dueDateUpdate) {
		return this.managerService.updateByDueDate(managerId, dueDateUpdate);
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
