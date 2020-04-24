package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.ResponsavelDAO;
import br.com.fiap.jpa.uti.entity.Responsavel;

public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Long> implements ResponsavelDAO{

	public ResponsavelDAOImpl(EntityManager em) {
		super(em);
	}

}
