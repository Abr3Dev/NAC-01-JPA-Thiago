package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.ExameDAO;
import br.com.fiap.jpa.uti.entity.Exame;

public class ExameDAOImpl extends GenericDAOImpl<Exame, Long> implements ExameDAO{

	public ExameDAOImpl(EntityManager em) {
		super(em);
	}

}
