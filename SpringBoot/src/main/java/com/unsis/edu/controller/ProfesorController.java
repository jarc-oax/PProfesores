package com.unsis.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsis.edu.exception.ResourceNotFoundException;
import com.unsis.edu.model.Profesor;
import com.unsis.edu.repository.Profesor_Repository;

@RestController
@RequestMapping("/api/v1")
public class ProfesorController {
	@Autowired
	private Profesor_Repository profesorRepository;

	@GetMapping("/profesores")
	public List<Profesor> getAllProfesores() {
		return profesorRepository.findAll();
	}

	@GetMapping("/profesores/{id}")
	public ResponseEntity<Profesor> getProfesorById(@PathVariable(value = "id") Long profesorId)
			throws ResourceNotFoundException {
		Profesor profesor = profesorRepository.findById(profesorId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado para este id :: " + profesorId));
		return ResponseEntity.ok().body(profesor);
	}

	@PostMapping("/profesores")
	public Profesor createProfesor(@Valid @RequestBody Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@PutMapping("/profesores/{id}")
	public ResponseEntity<Profesor> updateProfesor(@PathVariable(value = "id") Long profesorId,
			@Valid @RequestBody Profesor profesorDetails) throws ResourceNotFoundException {
		Profesor profesor = profesorRepository.findById(profesorId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado para este id ::" + profesorId));

		profesor.setEmailId(profesorDetails.getEmailId());
		profesor.setApellido(profesorDetails.getApellido());
		profesor.setNombre(profesorDetails.getNombre());
		profesor.setCedula_prof(profesorDetails.getCedula_prof());
		profesor.setConacyt(profesorDetails.getConacyt());
		profesor.setLinkedin(profesorDetails.getLinkedin());
		profesor.setTwitter(profesorDetails.getTwitter());
		
		final Profesor updatedProfesor = profesorRepository.save(profesor);
		return ResponseEntity.ok(updatedProfesor);
	}

	@DeleteMapping("/profesores/{id}")
	public Map<String, Boolean> deleteProfesor(@PathVariable(value = "id") Long profesorId)
			throws ResourceNotFoundException {
		Profesor profesor = profesorRepository.findById(profesorId)
				.orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado para este id ::" + profesorId));

		profesorRepository.delete(profesor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
