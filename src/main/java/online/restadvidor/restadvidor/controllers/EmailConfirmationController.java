package online.restadvidor.restadvidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import online.restadvidor.restadvidor.model.RestaurantUser;
import online.restadvidor.restadvidor.response.MessageResponse;
import online.restadvidor.restadvidor.services.RestaurantUserService;

@Controller
@RequestMapping("email")
public class EmailConfirmationController {
	
	@Autowired
	RestaurantUserService service;
	//EmailConfirmationService emailService;
	
	@SuppressWarnings("unused")
	@GetMapping("link")
	public ResponseEntity<?> validateEmail(@RequestParam("confirm") String confirm) {
		RestaurantUser newConfirmation = service.findByConfirm(confirm);
		
		System.out.println("Estado antes de confirmar: " + newConfirmation.isActive());
		
		if(newConfirmation.getConfirm().equals(confirm)) {
			//EmailConfirm emailConfirm = new EmailConfirm();
			newConfirmation.setActive(true);
			service.save(newConfirmation);
			return ResponseEntity.ok(new MessageResponse("Confirmed email"));
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("The confirmation link it´s inavlid."));
		}
		
	}
}
