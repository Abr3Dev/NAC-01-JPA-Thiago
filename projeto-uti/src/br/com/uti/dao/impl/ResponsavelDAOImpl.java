package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.ResponsavelDAO;
import br.com.uti.entity.Responsavel;
import br.com.uti.generic.GenericDAOImpl;

public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Long> implements ResponsavelDAO{

	public ResponsavelDAOImpl(EntityManager em) {
		super(em);
	}

}
