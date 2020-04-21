package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.EnfermeiroDAO;
import br.com.uti.entity.Enfermeiro;
import br.com.uti.generic.GenericDAOImpl;

public class EnfermeiroDAOImpl extends GenericDAOImpl<Enfermeiro, Long> implements EnfermeiroDAO{

	public EnfermeiroDAOImpl(EntityManager em) {
		super(em);
	}

}
