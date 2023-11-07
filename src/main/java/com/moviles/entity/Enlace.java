package com.moviles.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_enlace")
public class Enlace {

	
	@Id
	@Column(name = "idenlace")
	private int codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "ruta")
	private String ruta;

	@OneToMany(mappedBy = "enlace")
	@JsonIgnore
	private List<RolEnlace> listaRolEnlace;
}
