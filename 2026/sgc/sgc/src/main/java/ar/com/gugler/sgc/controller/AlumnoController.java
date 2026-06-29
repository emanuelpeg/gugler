package ar.com.gugler.sgc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gugler.sgc.dto.AlumnoDTO;
import ar.com.gugler.sgc.dto.AlumnoNewDTO;
import ar.com.gugler.sgc.service.PersonaService;

@RestController
@RequestMapping
public class AlumnoController {

	private final PersonaService personaService;

	public AlumnoController(PersonaService personaService) {
		this.personaService = personaService;
	}

	@PostMapping("/alumnos")
	public ResponseEntity<AlumnoDTO> crear(@RequestBody AlumnoNewDTO alumno) {
		return ResponseEntity.ok(this.personaService.guardar(alumno));
	}
	
	@PutMapping("/alumnos")
	public ResponseEntity<AlumnoDTO> update(@RequestBody AlumnoDTO alumno) {
		var opt = this.personaService.update(alumno);
		if (opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opt.get());
	}
	
	
	@GetMapping("/alumnos")
	public ResponseEntity<List<AlumnoDTO>> getAllAlumno() {
		return ResponseEntity.ok(this.personaService.getAllAlumno());
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<AlumnoDTO> getById(@PathVariable Long id) {
		var opt = this.personaService.getAlumnoBy(id);
		if (opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opt.get());
	}

}
