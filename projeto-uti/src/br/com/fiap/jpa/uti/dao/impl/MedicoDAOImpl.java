package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.MedicoDAO;
import br.com.fiap.jpa.uti.entity.Medico;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Long> implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

}
