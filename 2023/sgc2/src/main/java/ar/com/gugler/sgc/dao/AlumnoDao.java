package ar.com.gugler.sgc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.gugler.sgc.modelo.Alumno;

public interface AlumnoDao extends JpaRepository<Alumno, Long> {

}
