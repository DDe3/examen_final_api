package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClienteRestController;
import com.example.demo.controller.VueloRestController;
import com.example.demo.repository.ICompraPasajeRepo;
import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.to.ReportePasaje;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {
	
	@Autowired
	private ICompraPasajeRepo repo;

	@Override
	public String realizarCheckIn(String numero) {
		CompraPasaje cp = repo.buscarCompraPasaje(numero);
		cp.setEstado("Check-in");
		repo.actualizarCompraPasaje(cp);
		return "Check-in completo";
	}

	@Override
	public List<ReportePasaje> buscarPasajesHoy() {
		List<CompraPasaje> pasajes = repo.buscarTodos();
		List<CompraPasaje> pasajesHoy = pasajes.stream().filter( p -> p.getVuelo().getFechaVuelo()==LocalDate.now()).collect(Collectors.toList());
		List<ReportePasaje> ret = new ArrayList<>();
		for (CompraPasaje compraPasaje : pasajesHoy) {
			ret.add(mapCompraPasaje(compraPasaje));
		}
		return ret;
	}

	@Override
	public CompraPasaje buscarPasaje(String numero) {
		return repo.buscarCompraPasaje(numero);
	}
	
	private ReportePasaje mapCompraPasaje(CompraPasaje cp) {
		ReportePasaje rp = new ReportePasaje();
		rp.setNumeroVuelo(cp.getVuelo().getNumero());
		rp.setFechaVuelo(cp.getVuelo().getFechaVuelo());
		rp.setVueloEstado(cp.getVuelo().getEstado());
		rp.setNumeroCompra(cp.getNumero());
		rp.setCantidadAsientos(cp.getCantidadAsientosComprados());
		rp.setCompraEstado(cp.getEstado());
		rp.setNombreCliente(cp.getCliente().getNombre());
		Link linkCliente = linkTo( methodOn(ClienteRestController.class).buscarCliente(cp.getCliente().getCedula())).withRel("cliente");
		rp.add(linkCliente);
		Link linkVuelo = linkTo( methodOn(VueloRestController.class).buscarVuelo(cp.getVuelo().getNumero())).withRel("vuelo");
		rp.add(linkVuelo);
		return rp;
	}
	
	
	
}
