package online.restadvidor.restadvidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import online.restadvidor.restadvidor.model.EmailConfirm;
import online.restadvidor.restadvidor.response.MessageResponse;
import online.restadvidor.restadvidor.services.EmailConfirmationService;

@Controller
@RequestMapping("email")
public class EmailConfirmationController {
	
	@Autowired
	EmailConfirmationService emailService;
	
	@SuppressWarnings("unused")
	@GetMapping("link")
	public ResponseEntity<?> validateEmail(@RequestParam("confirm") String confirm) {
		EmailConfirm newConfirmation = emailService.findByConfirm(confirm);
		System.out.println("Estado antes de confirmar: " + newConfirmation.isActive());
		
		if(newConfirmation != null) {
			//EmailConfirm emailConfirm = new EmailConfirm();
			newConfirmation.setActive(true);
			emailService.save(newConfirmation);
			return ResponseEntity.ok(new MessageResponse("Confirmed email"));
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("The confirmation link it´s inavlid."));
		}
		
	}
}
