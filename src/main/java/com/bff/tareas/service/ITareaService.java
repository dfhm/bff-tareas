package com.bff.tareas.service;

import java.util.List;

import com.bff.tareas.model.Tarea;

public interface ITareaService {
	public List<Tarea> findAll();

	public Tarea findById(Long id);

	public Tarea add(Tarea tarea);
	
	public void delete(Long id);
	
	public Tarea modificar(Tarea tarea);
}
