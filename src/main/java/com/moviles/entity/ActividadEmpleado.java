package com.moviles.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_actividad_empleado")
public class ActividadEmpleado {
	
	@Id
	@Column(name = "detalle_devolucion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_actividad",referencedColumnName = "id_actividad")
	private Actividades actividad;// ASOCI.


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_empleado",referencedColumnName = "id_empleado")
	private Empleado empleado;// ASOCI.
	

	

}
