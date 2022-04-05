package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVueloRepo;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.to.BuscarVuelo;
import com.example.demo.to.ComprarVuelo;
import com.example.demo.to.VueloTo;

@Service
public class VueloServiceImpl implements IVueloService {
	
	@Autowired
	private IVueloRepo iVueloRepo;
	
	@Autowired
	private IClienteService clienteService;

	@Override
	public List<VueloTo> buscarVuelosDisponibles(BuscarVuelo buscarVuelo) {
		List<Vuelo> vuelos = iVueloRepo.buscarVuelosDisponibles(buscarVuelo.getOrigen(), buscarVuelo.getDestino(), LocalDate.parse(buscarVuelo.getFechaVuelo()));
		List<Vuelo> vuelosDisponibles = vuelos.stream().filter(v->v.getEstado()!="Disponible").collect(Collectors.toList());
		return vuelosDisponibles.stream().map(v->mapVuelo(v)).collect(Collectors.toList());
	}
	
	
	private VueloTo mapVuelo(Vuelo v) {
		VueloTo vto = new VueloTo();
		vto.setNumeroVuelo(v.getNumero());
		vto.setOrigen(v.getOrigen());
		vto.setDestino(v.getDestino());
		vto.setCategoria(v.getCategoria());
		vto.setNombre(v.getAvion().getNombre());
		vto.setValorAsiento(v.getValorAsiento());
		vto.setNumeroAsientos(v.getAsientosDisponibles());
		return vto;
	}


	@Override
	public VueloTo buscarVueloDisponible(String numeroVuelo) {
		Vuelo v = iVueloRepo.buscarVueloPorNumero(numeroVuelo);
		if (v!=null) {
			if (v.getEstado()=="Disponible") {
				return mapVuelo(v);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}


	@Override
	public String comprarVuelo(ComprarVuelo comprarVuelo) {
		Vuelo v = iVueloRepo.buscarVueloPorNumero(comprarVuelo.getNumeroVuelo());
		if (v!=null) {
			Integer asientosDisponibles = v.getAsientosDisponibles();
			if (asientosDisponibles>=comprarVuelo.getCantidad()) {
				CompraPasaje comprapasaje = new CompraPasaje();
				comprapasaje.setNumero(UUID.randomUUID().toString());
				comprapasaje.setFechaCompra(LocalDate.now());
				comprapasaje.setNumeroTarjeta(comprarVuelo.getTarjeta());
				comprapasaje.setCantidadAsientosComprados(comprarVuelo.getCantidad());
				comprapasaje.setEstado("Reservado");
				Cliente c = clienteService.buscarClientePorCedula(comprarVuelo.getCedula());
				
				c.insertarPasaje(comprapasaje);
				v.addPasaje(comprapasaje);
				
				v.setAsientosDisponibles(v.getAsientosDisponibles()-comprarVuelo.getCantidad());
				if (v.getAsientosDisponibles()<=0) {
					v.setEstado("No Disponible");
				}
				
				iVueloRepo.actualizarVuelo(v);
				return "Vuelo reservado";
			} else {
				return "Asientos insuficientes";
			}
		} else {
			return "No existe ese vuelo";
		}
		
	}


	@Override
	public VueloTo buscarVuelo(String numeroVuelo) {
		Vuelo v = iVueloRepo.buscarVueloPorNumero(numeroVuelo);
		return mapVuelo(v);
	}
	
	
}
