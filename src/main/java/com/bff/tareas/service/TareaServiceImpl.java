package com.bff.tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.tareas.feing.TareaFeign;
import com.bff.tareas.model.Tarea;

@Service("serviceFeign")
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private TareaFeign clienteTarea;

	@Override
	public List<Tarea> findAll() {
		return clienteTarea.listar();
	}

	@Override
	public Tarea findById(Long id) {
		return clienteTarea.getTarea(id);
	}

	@Override
	public Tarea add(Tarea tarea) {
		return clienteTarea.addTarea(tarea);

	}

	@Override
	public void delete(Long id) {
		clienteTarea.deleteTarea(id);

	}

	@Override
	public Tarea modificar(Tarea tarea) {
		return clienteTarea.editTarea(tarea);
	}

}
