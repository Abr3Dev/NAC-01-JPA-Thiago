package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.EnderecoDAO;
import br.com.uti.entity.Endereco;
import br.com.uti.generic.GenericDAOImpl;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Long> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager em) {
		super(em);
		
	}

}
