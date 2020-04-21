package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.MedicacaoDAO;
import br.com.uti.entity.Medicacao;
import br.com.uti.generic.GenericDAOImpl;

public class MedicacaoDAOImpl extends GenericDAOImpl<Medicacao, Long> implements MedicacaoDAO{

	public MedicacaoDAOImpl(EntityManager em) {
		super(em);
	}

}
