package ar.com.gugler.sgc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.gugler.sgc.dao.AlumnoDao;
import ar.com.gugler.sgc.modelo.Alumno;

@Service
public class AlumnoService {

	private AlumnoDao alumnoDao;

	public AlumnoService(AlumnoDao alumnoDao) {
		super();
		this.alumnoDao = alumnoDao;
	}
	
	public Optional<Alumno> getAlumno(long id) {
		return this.alumnoDao.findById(id);
	}
	
	public List<Alumno> getAlumnos() {
		return this.alumnoDao.findAll();
	}
	
	public void saveAlumno(Alumno alumno) {
		this.alumnoDao.save(alumno);
	}
	
}
