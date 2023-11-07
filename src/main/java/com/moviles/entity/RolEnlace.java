package com.moviles.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_rol_enlace")
public class RolEnlace {
	
	@EmbeddedId
	private RolEnlacePK id;

	@ManyToOne
	@JoinColumn(name = "idrol", insertable = false, updatable = false, referencedColumnName = "idrol")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "idenlace", insertable = false, updatable = false, referencedColumnName = "idenlace")
	private Enlace enlace;

}
