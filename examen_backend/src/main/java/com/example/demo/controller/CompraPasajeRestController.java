package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.service.ICompraPasajeService;
import com.example.demo.to.ReportePasaje;

@RestController
@RequestMapping("/ApiCompraPasaje/V1/CompraPasajes")
public class CompraPasajeRestController {
	
	@Autowired
	private ICompraPasajeService service;
	
	@PutMapping(path = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> realizarCheckIn(@PathVariable("numero") String numero) {
		return ResponseEntity.ok(service.realizarCheckIn(numero));
	}
	
	@GetMapping(path = "/{numero}")
	public ResponseEntity<ReportePasaje> buscarPasaje(@PathVariable("numero") String numero) {
		return null;
	}

}
