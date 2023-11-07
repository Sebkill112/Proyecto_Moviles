package com.moviles.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_tipo_empleado")
public class TipoEmpleado {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private Integer codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy="tipo")
	@JsonIgnore
	private List<Empleado> listaEmpleados;
}
