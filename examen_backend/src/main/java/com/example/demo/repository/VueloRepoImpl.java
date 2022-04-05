package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.to.BuscarVuelo;

@Transactional
@Repository
public class VueloRepoImpl implements IVueloRepo {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDate fechaVuelo) {
		TypedQuery<Vuelo> mq = em.createQuery("SELECT a FROM Avion a WHERE a.origen=:origen AND a.destino=:destino AND a.fechaVuelo=:fechaVuelo",Vuelo.class);
		mq.setParameter("origen", origen);
		mq.setParameter("destino", destino);
		mq.setParameter("fechaVuelo", fechaVuelo);
		return mq.getResultList();
	}

	@Override
	public String actualizarVuelo(Vuelo vuelo) {
		em.merge(vuelo);
		return "Vuelo actualizado";
	}

	@Override
	public Vuelo buscarVueloPorNumero(String numero) {
		TypedQuery<Vuelo> mq = em.createQuery("SELECT a FROM Avion a WHERE a.numero=:numero", Vuelo.class);
		mq.setParameter("numero", numero);
		return mq.getSingleResult();
	}
	
	
	
	

}
