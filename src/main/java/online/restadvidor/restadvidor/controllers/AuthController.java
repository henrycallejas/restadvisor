package online.restadvidor.restadvidor.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.restadvidor.restadvidor.model.ERole;
import online.restadvidor.restadvidor.model.EmailConfirm;
import online.restadvidor.restadvidor.model.RestaurantUser;
import online.restadvidor.restadvidor.model.Role;
import online.restadvidor.restadvidor.request.LoginRequest;
import online.restadvidor.restadvidor.request.SignupRequest;
import online.restadvidor.restadvidor.response.JwtResponse;
import online.restadvidor.restadvidor.response.MessageResponse;
import online.restadvidor.restadvidor.services.EmailConfirmationService;
import online.restadvidor.restadvidor.services.UserDetailsImpl;
import online.restadvidor.restadvidor.utils.EmailConfirmation;
import online.restadvidor.restadvidor.irepository.*;
import online.restadvidor.restadvidor.security.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	EmailConfirmationService emailService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RestaurantUserRepository userRepository;

	@Autowired
	RolRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		RestaurantUser user = new RestaurantUser(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		
		//comienza la logica del email
		
		RestaurantUser newUser = userRepository.save(user);
		EmailConfirm emailConfirm = new EmailConfirm();
		emailConfirm.setActive(false);
		emailConfirm.setUserId(newUser.getUserId());
		
		try {
			String confirmHash = EmailConfirmation.sendConfirmationLink(newUser.getEmail());
			TimeUnit.SECONDS.sleep(5);
			emailConfirm.setConfirm(confirmHash);
			emailService.save(emailConfirm);
			
			//TERMINA LA LOGICA DEL EMAIL
			userRepository.save(user);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully! Please click on the link we have sent to your email"));
	}
}
