package ar.com.gugler.sgc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gugler.sgc.modelo.Curso;
import ar.com.gugler.sgc.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	private CursoService cursoService;

	public CursoController(CursoService cursoService) {
		super();
		this.cursoService = cursoService;
	}
	
	@GetMapping
	public List<Curso> getCursos() {
		return this.cursoService.getCursos();
	}
	
	@PostMapping
	public void saveCurso(@RequestBody Curso curso) {
		this.cursoService.saveCurso(curso);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Boolean> saveCurso(@PathVariable("id") Long idCurso, @RequestBody Long idAlumno) {
		if (this.cursoService.addAlumno(idCurso, idAlumno)) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.notFound().build();
	}
	
}
