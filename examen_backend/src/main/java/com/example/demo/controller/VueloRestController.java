package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVueloService;
import com.example.demo.to.BuscarVuelo;
import com.example.demo.to.ComprarVuelo;
import com.example.demo.to.VueloTo;

@RestController
@RequestMapping("/ApiVuelos/V1/vuelos")
public class VueloRestController {
	
	@Autowired
	private IVueloService service;
	
	@GetMapping(path = "/disponibles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VueloTo>> buscarVuelosDisponibles(@RequestBody BuscarVuelo bv) {
		return ResponseEntity.ok(service.buscarVuelosDisponibles(bv));
	}
	
	@GetMapping(path = "/disponibles/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VueloTo> buscarVueloDisponible(@PathVariable("numero") String numero) {
		return ResponseEntity.ok(service.buscarVueloDisponible(numero));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> reservarVuelo(@RequestBody ComprarVuelo cv) {
		return ResponseEntity.ok(service.comprarVuelo(cv));
	}
	
	@GetMapping(path = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VueloTo> buscarVuelo(@PathVariable("numero") String numero) {
		return ResponseEntity.ok(service.buscarVuelo(numero));
	}
	

}
