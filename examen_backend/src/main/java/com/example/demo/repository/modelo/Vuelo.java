package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vuelo")
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuelo")
	@SequenceGenerator(name = "seq_vuelo", sequenceName = "seq_vuelo", allocationSize = 1)
	@Column(name="vuel_id")
	private Integer id;
	
	@Column(name="vuel_numero", unique = true)
	private String numero;
	@Column(name="vuel_fechaVuelo")
	private LocalDate fechaVuelo;
	@Column(name="vuel_asientos_disponibles")
	private Integer asientosDisponibles;
	@Column(name="vuel_valor_asiento")
	private Double valorAsiento;
	@Column(name="vuel_estado")
	private String estado;
	@Column(name="vuel_origen")
	private String origen;
	@Column(name="vuel_destino")
	private String destino;
	@Column(name="vuel_categoria")
	private String categoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
	private List<CompraPasaje> pasajes;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "avio_id")
	private Avion avion;
	
	
	public void addPasaje(CompraPasaje comprapasaje) {
		pasajes.add(comprapasaje);
		comprapasaje.setVuelo(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Double getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(Double valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CompraPasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<CompraPasaje> pasajes) {
		this.pasajes = pasajes;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	

}
