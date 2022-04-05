package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.service.IClienteService;
import com.example.demo.to.BuscarVuelo;

@RestController
@RequestMapping("/ApiClientes/V1/clientes")
public class ClienteRestController {
	
	@Autowired
	private IClienteService service;
	
	
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarCliente(@PathVariable("cedula") String cedula) {
		return ResponseEntity.ok(service.buscarClientePorCedula(cedula));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(service.insertarCliente(cliente));
	}

}
