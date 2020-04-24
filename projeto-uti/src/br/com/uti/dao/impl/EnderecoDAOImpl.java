package br.com.uti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.uti.dao.EnderecoDAO;
import br.com.uti.entity.Endereco;
import br.com.uti.generic.GenericDAOImpl;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Long> implements EnderecoDAO{
	
	private EntityManager em;
	
	public EnderecoDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public void cadastrar(List<Endereco> ends) {
		em.persist(ends);
	}

}
