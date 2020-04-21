package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.ExameDAO;
import br.com.uti.entity.Exame;
import br.com.uti.generic.GenericDAOImpl;

public class ExameDAOImpl extends GenericDAOImpl<Exame, Long> implements ExameDAO{

	public ExameDAOImpl(EntityManager em) {
		super(em);
	}

}
