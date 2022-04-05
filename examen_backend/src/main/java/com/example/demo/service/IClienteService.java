package com.example.demo.service;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {
	
	Cliente buscarClientePorCedula(String cedula);
	String insertarCliente(Cliente cliente);

}
