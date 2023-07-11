package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.RecursoNoEncontrado;
import com.example.demo.model.Incidencia;
import com.example.demo.repository.IncidenciaRepository;
import com.example.demo.service.IncidenciaService;


@Service
public class IncidenciaServiceImpl implements IncidenciaService {

	//Se usa inyección de dependencia en Spring para usar un objetoen otro objeto
	private IncidenciaRepository incidenciaRepository;
	public IncidenciaServiceImpl(IncidenciaRepository incidenciaRepository) {
		super();
		this.incidenciaRepository = incidenciaRepository;
	}
	
	@Override
	public Incidencia saveIncidencia(Incidencia incidencia) {
		return incidenciaRepository.save(incidencia);
	}
	@Override
	 public List<Incidencia> getAllIncidencias() {		
		return incidenciaRepository.findAll();
	 }
	
	@Override
	public Incidencia getIncidenciaById(long id) {
		
		return incidenciaRepository.findById(id).orElseThrow(()->
		new RecursoNoEncontrado("Incidencia","id",id));
	}
	
	@Override
	public Incidencia updateIncidencia(Incidencia incidencia,long id) {
		// TODO Auto-generated method stub
		
		Incidencia incidenciaExistente = incidenciaRepository.findById(id)
				.orElseThrow(()-> new RecursoNoEncontrado("Incidencia","Id",id));
		
		incidenciaExistente.setId(incidencia.getId());
		incidenciaExistente.setFecha(incidencia.getFecha());
		incidenciaExistente.setPrioridad(incidencia.getPrioridad());
		incidenciaExistente.setResponsable(incidencia.getResponsable());
		incidenciaExistente.setArea(incidencia.getArea());
		incidenciaExistente.setDescripcion(incidencia.getDescripcion());
		
		incidenciaRepository.save(incidenciaExistente);
		
		return incidenciaExistente;
	}
	
	@Override
	public void deleteIncidencia(long id) {
		
		incidenciaRepository.findById(id)
		.orElseThrow(()-> new RecursoNoEncontrado("Incidencia","Id",id));
		
		incidenciaRepository.deleteById(id);
		
	}
	
}
