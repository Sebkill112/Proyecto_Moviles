package com.moviles.auth;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.entity.Enlace;
import com.moviles.entity.Jefe;
import com.moviles.entity.Rol;
import com.moviles.entity.Usuario;
import com.moviles.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		try {
			AuthResponse authResponse = authService.login(request);
			return ResponseEntity.ok(authResponse);
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception (consider using a proper logging framework).
			String errorResponse = "Usuario y/o Contraseña invalida";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(errorResponse);
		}
	}

	@PostMapping(value = "register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws ParseException {

		boolean usernameExists = userRepository.existsByUsername(request.getUsername());

		if (usernameExists) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("El Usuario con Username: " + request.getUsername() + " ya está registrado");
		} else {
			Usuario user = new Usuario();
			userRepository.save(user);

			user.setNombre(request.getNombre());
			user.setApellido(request.getApellido());
			user.setUsername(request.getUsername());
			user.setPassword(passwordEncoder.encode(request.getPassword()));
			Rol rol = new Rol();
			rol.setCodigo(request.getRol());
			user.setTipoRol(rol);

			userRepository.save(user);

			return ResponseEntity.ok("Usuario registrado correctamente");
		}

	}


	@PutMapping(value = "password")
	@ResponseBody
	@Transactional
	public ResponseEntity<String> cambiarPassword(@RequestBody PasswordResponse request) {


			String pass = passwordEncoder.encode(request.getPassword());
			int user = request.getCodigo();
			
			userRepository.actualizarContraseña(pass, user);
			
			return ResponseEntity.ok("Contraseña del usuario actualizada correctamente");
		}
	}

