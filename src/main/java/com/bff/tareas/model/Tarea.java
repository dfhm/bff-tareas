package com.bff.tareas.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Tarea {
	private Long id;
	@NotBlank(message = "Descripcion es obligatoria")
	private String descripcion;
	@NotNull(message = "Fecha creacion es obligatoria")
	private Date fechaCreacion;
	@NotNull(message = "Vigencia es obligatoria")
	private Boolean vigente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

}
