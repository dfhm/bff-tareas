package com.bff.tareas.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bff.tareas.model.Tarea;

@FeignClient(name = "ms-tareas", url = "ms-tareas:8081")
public interface TareaFeign {

	@GetMapping("/listar")
	public List<Tarea> listar();

	@GetMapping("/tarea/{id}")
	public Tarea getTarea(@PathVariable Long id);

	@PostMapping("/agregar")
	public Tarea addTarea(@RequestBody Tarea tarea);

	@DeleteMapping("/eliminar/{id}")
	public void deleteTarea(@PathVariable Long id);

	@PutMapping("/modificar")
	public Tarea editTarea(@RequestBody Tarea tarea);
}
