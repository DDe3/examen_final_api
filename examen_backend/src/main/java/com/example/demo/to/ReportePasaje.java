package com.example.demo.to;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

public class ReportePasaje extends RepresentationModel<ReportePasaje> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String numeroVuelo;
	private LocalDate fechaVuelo;
	private String vueloEstado;
	private String numeroCompra;
	private Integer cantidadAsientos;
	private String compraEstado;
	private String nombreCliente;
	
	
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public String getVueloEstado() {
		return vueloEstado;
	}
	public void setVueloEstado(String vueloEstado) {
		this.vueloEstado = vueloEstado;
	}
	public String getNumeroCompra() {
		return numeroCompra;
	}
	public void setNumeroCompra(String numeroCompra) {
		this.numeroCompra = numeroCompra;
	}
	public Integer getCantidadAsientos() {
		return cantidadAsientos;
	}
	public void setCantidadAsientos(Integer cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}
	public String getCompraEstado() {
		return compraEstado;
	}
	public void setCompraEstado(String compraEstado) {
		this.compraEstado = compraEstado;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	

}
