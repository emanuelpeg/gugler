package ar.com.gugler.sgc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.gugler.sgc.modelo.Curso;

public interface CursoDao extends JpaRepository<Curso, Long> {

}
