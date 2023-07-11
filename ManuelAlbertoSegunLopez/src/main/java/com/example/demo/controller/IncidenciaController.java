package com.example.demo.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Incidencia;
import com.example.demo.service.IncidenciaService;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
	
	private IncidenciaService incidenciaService;
	public IncidenciaController(IncidenciaService incidenciaService) {
	  super();
	  this.incidenciaService = incidenciaService;	
    }
	//endpoint - Creación de incidencia
		@PostMapping
		public ResponseEntity<Incidencia> saveIncidencia(@RequestBody Incidencia incidencia){
			return new ResponseEntity<Incidencia>(incidenciaService.saveIncidencia(incidencia),HttpStatus.CREATED);
			
		}
		//endpoint - Coger todos las incidencias
		@GetMapping
		public List<Incidencia> getAllIncidencias(){
			return incidenciaService.getAllIncidencias();
		}
		
		//endpoint - Coger la incidencia por su Id
		@GetMapping("{id}")
		public ResponseEntity<Incidencia> getIncidenciayId(@PathVariable("id") long id){
			return new ResponseEntity<Incidencia>(incidenciaService.getIncidenciaById(id),HttpStatus.OK);
			
		}
		//endpoint - Actualizar una incidencia por su id
		@PutMapping("{id}")
		public ResponseEntity<Incidencia> updateIncidencia(@PathVariable("id") long id,
				@RequestBody Incidencia incidencia){
			return new ResponseEntity<Incidencia>(incidenciaService.updateIncidencia(incidencia, id),HttpStatus.OK);
					
		}
		
		//endpoint - Borrar una incidencia
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteIncidencia(@PathVariable("id") long id){
			
			incidenciaService.deleteIncidencia(id);		
			return new ResponseEntity<String>("Incidencia borrada con éxito!",HttpStatus.OK);
		}
}	
