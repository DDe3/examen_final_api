package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepo repo;

	@Override
	public Cliente buscarClientePorCedula(String cedula) {
		return repo.buscarClientePorCedula(cedula);
	}

}
