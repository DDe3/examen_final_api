package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CompraPasaje;

@Transactional
@Repository
public class CompraPasajeRepoImpl implements ICompraPasajeRepo {
	
	@Autowired
	private EntityManager em;

	@Override
	public void actualizarCompraPasaje(CompraPasaje compraPasaje) {
		em.merge(compraPasaje);
	}

	@Override
	public CompraPasaje buscarCompraPasaje(String numero) {
		TypedQuery<CompraPasaje> mq = em.createQuery("SELECT c FROM CompraPasaje c WHERE c.numero=:numero", CompraPasaje.class);
		mq.setParameter("numero", numero);
		return mq.getSingleResult();
	}

	@Override
	public List<CompraPasaje> buscarTodos() {
		TypedQuery<CompraPasaje> mq = em.createQuery("SELECT c FROM CompraPasaje c", CompraPasaje.class);
		return mq.getResultList();
	}

	
	

}
