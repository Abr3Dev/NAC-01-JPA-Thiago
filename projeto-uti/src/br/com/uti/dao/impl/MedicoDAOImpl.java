package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.MedicoDAO;
import br.com.uti.entity.Medico;
import br.com.uti.generic.GenericDAOImpl;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Long> implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

}
