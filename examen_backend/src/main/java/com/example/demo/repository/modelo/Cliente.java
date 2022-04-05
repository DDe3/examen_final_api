package com.example.demo.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	@Column(name="clie_id")
	private Integer id;
	
	@Column(name="clie_nombre")
	private String nombre;
	
	@Column(name="clie_cedula", unique = true)
	private String cedula;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<CompraPasaje> pasajes;


	
	public void insertarPasaje(CompraPasaje pasaje) {
		pasajes.add(pasaje);
		pasaje.setCliente(this);
	}
	
	public Integer getId() {
		return id;
	}

	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<CompraPasaje> getPasajes() {
		return pasajes;
	}


	public void setPasajes(List<CompraPasaje> pasajes) {
		this.pasajes = pasajes;
	}
	
	

	
	
	
	
	
	

}
