package br.com.fiap.jpa.uti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.EnderecoDAO;
import br.com.fiap.jpa.uti.entity.Endereco;

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
