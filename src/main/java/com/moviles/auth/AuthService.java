package com.moviles.auth;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moviles.entity.Enlace;
import com.moviles.entity.Usuario;
import com.moviles.jwt.JwtService;
import com.moviles.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	private final JwtService jwtService;
	 private final PasswordEncoder passwordEncoder;
	 private final AuthenticationManager authenticationManager;
	 
	 
	 public List<Enlace> enlacesDelUsuario(int rol){
			return userRepository.traerEnlacesDelUsuario(rol);
		}
	 

	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Usuario usu = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .codigo(usu.getCodigo())
            .username(usu.getUsername())
            .rol(usu.getTipoRol())
            .build();

	}
	
}
