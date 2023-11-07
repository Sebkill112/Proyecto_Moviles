package com.moviles.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.moviles.entity.Enlace;
import com.moviles.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByUsername(String user);

	boolean existsByUsername(String username);

	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codigoRol);

	@Modifying
	@Query(value = "update tb_usuario set password = ?1 WHERE username = ?2", nativeQuery = true)
	public void actualizarContraseña(String password, String username);
}
