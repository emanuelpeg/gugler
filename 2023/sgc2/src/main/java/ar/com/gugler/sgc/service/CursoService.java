package ar.com.gugler.sgc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.gugler.sgc.dao.AlumnoDao;
import ar.com.gugler.sgc.dao.CursoDao;
import ar.com.gugler.sgc.modelo.Curso;

@Service
public class CursoService {
	
	private CursoDao cursoDao;
	private AlumnoDao alumnoDao;

	public CursoService(CursoDao cursoDao, AlumnoDao alumnoDao) {
		super();
		this.cursoDao = cursoDao;
		this.alumnoDao = alumnoDao;
	}
	
	public List<Curso> getCursos() {
		return this.cursoDao.findAll();
	}
	
	public void saveCurso(Curso curso) {
		this.cursoDao.save(curso);
	}
	
	public boolean addAlumno(Long idCurso, Long idAlumno) {
		var alumno = this.alumnoDao.findById(idAlumno);
		if (alumno.isEmpty()) {
			return false;
		}
		var curso = this.cursoDao.findById(idCurso);
		if (curso.isEmpty()) {
			return false;
		}
		
		curso.get().agregarAlumno(alumno.get());
		this.cursoDao.save(curso.get());
		return true;
	}

}
