package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo {
	
	@Autowired
	private EntityManager em;

	@Override
	public Cliente buscarClientePorCedula(String cedula) {
		TypedQuery<Cliente> mq = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula",Cliente.class);
		mq.setParameter("cedula", cedula);
		return mq.getSingleResult();
	}

}
