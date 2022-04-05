package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.to.ReportePasaje;

public interface ICompraPasajeService {
	
	String realizarCheckIn(String numero);
	List<ReportePasaje> buscarPasajesHoy();
	CompraPasaje buscarPasaje(String numero);
	

}
