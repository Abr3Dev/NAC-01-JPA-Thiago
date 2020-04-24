package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.MedicacaoDAO;
import br.com.fiap.jpa.uti.entity.Medicacao;

public class MedicacaoDAOImpl extends GenericDAOImpl<Medicacao, Long> implements MedicacaoDAO{

	public MedicacaoDAOImpl(EntityManager em) {
		super(em);
	}

}
