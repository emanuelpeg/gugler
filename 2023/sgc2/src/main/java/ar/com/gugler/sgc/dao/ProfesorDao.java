package ar.com.gugler.sgc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.gugler.sgc.modelo.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Long>{

}
