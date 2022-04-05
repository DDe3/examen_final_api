package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Vuelo;

public interface IVueloRepo {
	
	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDate fechaVuelo);
	String actualizarVuelo(Vuelo vuelo);
	Vuelo buscarVueloPorNumero(String numero);

}
