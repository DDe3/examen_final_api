package com.example.demo.service;

import java.util.List;

import com.example.demo.to.BuscarVuelo;
import com.example.demo.to.ComprarVuelo;
import com.example.demo.to.VueloTo;

public interface IVueloService {
	
	List<VueloTo> buscarVuelosDisponibles(BuscarVuelo buscarVuelo);
	VueloTo buscarVueloDisponible(String numeroVuelo);
	String comprarVuelo(ComprarVuelo comprarVuelo);
	VueloTo buscarVuelo(String numeroVuelo);

}
