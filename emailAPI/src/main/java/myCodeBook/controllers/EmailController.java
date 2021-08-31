package myCodeBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import myCodeBook.model.EmailRequest;
import myCodeBook.services.EmailServices;

@RestController
public class EmailController {
	
	
	@Autowired
	private EmailServices emailServices;
	
	@GetMapping("/email")
	public String email() {
		return "I am your first email";
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		System.out.println(request);
		boolean email = this.emailServices.sendEmail(request.getTo(), request.getTo(), request.getMessage());
		
		if(email) {
			return ResponseEntity.ok("Message is successfully send....");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		
	}
}
