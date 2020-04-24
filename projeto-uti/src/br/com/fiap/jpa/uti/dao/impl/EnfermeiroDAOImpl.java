package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.EnfermeiroDAO;
import br.com.fiap.jpa.uti.entity.Enfermeiro;

public class EnfermeiroDAOImpl extends GenericDAOImpl<Enfermeiro, Long> implements EnfermeiroDAO{

	public EnfermeiroDAOImpl(EntityManager em) {
		super(em);
	}

}
