package ar.com.gugler.sgc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gugler.sgc.modelo.Alumno;
import ar.com.gugler.sgc.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	private AlumnoService alumnoService;

	public AlumnoController(AlumnoService alumnoService) {
		super();
		this.alumnoService = alumnoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable("id") Long id) {
		var opAlumno = this.alumnoService.getAlumno(id);
		if (opAlumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opAlumno.get());
	}
	
	@GetMapping
	public List<Alumno> getAlumnos() {
		return this.alumnoService.getAlumnos();
	}
	
	@PostMapping
	public void saveAlumno(@RequestBody Alumno alumno) {
		this.alumnoService.saveAlumno(alumno);
	}
	
	
}
