package com.moviles.auth;

import com.moviles.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	int codigo;
	String username;
	Rol rol;
	String token;
}
