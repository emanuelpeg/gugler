package ar.com.gugler.sgc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.gugler.sgc.dao.AlumnoRepository;
import ar.com.gugler.sgc.dao.ProfesorRepository;
import ar.com.gugler.sgc.dto.AlumnoDTO;
import ar.com.gugler.sgc.dto.AlumnoNewDTO;
import ar.com.gugler.sgc.modelo.Alumno;

@Service
public class PersonaServiceImpl implements PersonaService {

	private AlumnoRepository alumnoRepo;
	private ProfesorRepository profeRepo;

	public PersonaServiceImpl(AlumnoRepository alumnoRepo, ProfesorRepository profeRepo) {
		super();
		this.alumnoRepo = alumnoRepo;
		this.profeRepo = profeRepo;
	}

	@Override
	public AlumnoDTO guardar(AlumnoNewDTO alumnoDTO) {
		var alumno = this.alumnoRepo.save(new Alumno(alumnoDTO.numeroDocumento(), alumnoDTO.apellido(),
				alumnoDTO.nombres(), alumnoDTO.fechaNacimiento(), alumnoDTO.domicilio(), alumnoDTO.telefono(),
				alumnoDTO.correoElectronico(), alumnoDTO.legajo()));
		return new AlumnoDTO(alumno.getId(), alumno.getNumeroDocumento(), alumno.getLegajo(), alumno.getApellido(),
				alumno.getNombres(), alumno.getFechaNacimiento(), alumno.getDomicilio(), alumno.getTelefono(),
				alumno.getCorreoElectronico());
	}

	public List<AlumnoDTO> getAllAlumno() {
		return this.alumnoRepo.findAll().stream()
				.map(alumno -> new AlumnoDTO(alumno.getId(), alumno.getNumeroDocumento(), alumno.getLegajo(),
						alumno.getApellido(), alumno.getNombres(), alumno.getFechaNacimiento(), alumno.getDomicilio(),
						alumno.getTelefono(), alumno.getCorreoElectronico()))
				.toList();
	}

	@Override
	public Optional<AlumnoDTO> getAlumnoBy(Long id) {
		return this.alumnoRepo.findById(id)
				.map(alumno -> new AlumnoDTO(alumno.getId(), alumno.getNumeroDocumento(), alumno.getLegajo(),
						alumno.getApellido(), alumno.getNombres(), alumno.getFechaNacimiento(), alumno.getDomicilio(),
						alumno.getTelefono(), alumno.getCorreoElectronico()));
	}

	@Override
	public Optional<AlumnoDTO> update(AlumnoDTO alumnoDTO) {
		var alumnoOpt = this.alumnoRepo.findById(alumnoDTO.id());
        if (alumnoOpt.isEmpty()) {
        	return Optional.empty();
        }
		var alumno = alumnoOpt.get();
		alumno.setApellido(alumnoDTO.apellido());
		alumno.setNumeroDocumento(alumnoDTO.numeroDocumento());
		alumno.setCorreoElectronico(alumnoDTO.correoElectronico());
		alumno.setDomicilio(alumnoDTO.domicilio());
		alumno.setLegajo(alumnoDTO.legajo());
		alumno.setFechaNacimiento(alumnoDTO.fechaNacimiento());
		alumno.setTelefono(alumnoDTO.telefono());
		alumno.setNombres(alumnoDTO.nombres());
		
		alumno = this.alumnoRepo.save(alumno);
		
		return Optional.of(new AlumnoDTO(alumno.getId(), alumno.getNumeroDocumento(), alumno.getLegajo(), alumno.getApellido(),
				alumno.getNombres(), alumno.getFechaNacimiento(), alumno.getDomicilio(), alumno.getTelefono(),
				alumno.getCorreoElectronico()));
	}

}
