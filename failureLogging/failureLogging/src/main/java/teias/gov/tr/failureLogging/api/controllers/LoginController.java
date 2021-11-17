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


import teias.gov.tr.failureLogging.business.abstracts.ILoginService;
import teias.gov.tr.failureLogging.core.utilites.result.DataResult;
import teias.gov.tr.failureLogging.core.utilites.result.ErrorDataResult;
import teias.gov.tr.failureLogging.core.utilites.result.Result;
import teias.gov.tr.failureLogging.entities.concretes.Login;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	private ILoginService loginService;
	
	@Autowired
	public LoginController(ILoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@GetMapping("/getall")
	public DataResult<List< Login>> getAll(){
		return this.loginService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Login login) {	
		return ResponseEntity.ok(this.loginService.add(login));
	
	}
	
	@DeleteMapping("/deleteByLoginId/{loginId}")
	public Result deleteByLoginId(@RequestParam(value = "loginId") int loginId) {
		return this.loginService.deleteByLoginId(loginId);
	}
	
	@PutMapping("/updateByEmail/{loginId}")
	public Result updateByEmail(@RequestParam(value = "loginId") int loginId,@RequestParam(value = "emailUpdate") String emailUpdate) {
		return this.loginService.updateByEmail(loginId, emailUpdate);
	}
	@PutMapping("/updateByPassword/{loginId}")
	public Result updateByPassword(@RequestParam(value = "loginId") int loginId,@RequestParam(value = "passwordUpdate") String passwordUpdate) {
		return this.loginService.updateByPassword(loginId, passwordUpdate);
	}
	
	
	
	
	
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	

	public ErrorDataResult<Object>handleValidationException
	(MethodArgumentNotValidException exceptions) {
		
		Map<String, String> validationErrors=new HashMap<String, String>();
		
	// bu sistemde şu türde hata olursa bu metodu devreye sok diyoruz
	//mesela validasyon hatalarını
		
		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
	//bir üstteki for each yapısı
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	} 
	//validationEroorları bir error data resulta çevirmemizz lazım bu blokta;
		
		ErrorDataResult<Object>errors=new 
		ErrorDataResult<Object>(validationErrors, "doğrulama hataları");
		return errors;	
	}
		
	
	
	
	
}
