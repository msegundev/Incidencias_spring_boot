package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Incidencia;


public interface IncidenciaService {

	Incidencia saveIncidencia(Incidencia incidencia);
	List<Incidencia>getAllIncidencias();
	Incidencia getIncidenciaById(long id);
	Incidencia updateIncidencia(Incidencia incidencia,long id);
	void deleteIncidencia(long id);
}
