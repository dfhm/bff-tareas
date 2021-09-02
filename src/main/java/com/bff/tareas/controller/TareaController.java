package com.bff.tareas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bff.tareas.model.Tarea;
import com.bff.tareas.service.ITareaService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
public class TareaController {

	@Autowired
	private ITareaService tareaService;

	@GetMapping("/listar")

	public List<Tarea> listarTareas() {
		return tareaService.findAll();
	}

	@GetMapping("/tarea/{id}")
	@ApiImplicitParam(name = "id", value = "id Tarea a consultar", required = true, dataType = "Long")
	public Tarea getTarea(@PathVariable Long id) {
		return tareaService.findById(id);
	}

	@PostMapping("/agregar")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "descripcion", value = "descripcion tarea ", required = true, dataType = "String"),
			@ApiImplicitParam(name = "fechaCreacion", value = "Fecha Creacion", required = true, dataType = "Date"),
			@ApiImplicitParam(name = "vigente", value = "si tarea se encuentra vigente", required = true, dataType = "Boolean") })
	public Tarea addTarea(@Valid @RequestBody Tarea tarea) {
		return tareaService.add(tarea);
	}

	@DeleteMapping("/eliminar/{id}")
	@ApiImplicitParam(name = "id", value = "id Tarea a eliminar", required = true, dataType = "Long")
	public void deleteTarea(@PathVariable Long id) {
		tareaService.delete(id);
	}

	@PutMapping("/modificar")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id tarea a editar", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "descripcion", value = "Descripcion tarea ", required = true, dataType = "String"),
			@ApiImplicitParam(name = "fechaCreacion", value = "Fecha Creacion", required = true, dataType = "Date"),
			@ApiImplicitParam(name = "vigente", value = "si tarea se encuentra vigente", required = true, dataType = "Boolean") })
	public Tarea editTarea(@Valid @RequestBody Tarea tarea) {
		if (tareaService.findById(tarea.getId()) != null) {
			return tareaService.modificar(tarea);
		} else {
			return tarea;
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
