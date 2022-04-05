package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.CompraPasaje;

public interface ICompraPasajeRepo {
	
	void actualizarCompraPasaje(CompraPasaje compraPasaje);
	CompraPasaje buscarCompraPasaje(String numero);
	List<CompraPasaje> buscarTodos();

}
