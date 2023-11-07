package com.moviles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviles.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
