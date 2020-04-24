package br.com.fiap.jpa.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.uti.dao.PacienteDAO;
import br.com.fiap.jpa.uti.entity.Paciente;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Long> implements PacienteDAO{

	public PacienteDAOImpl(EntityManager em) {
		super(em);
		
	}

}
