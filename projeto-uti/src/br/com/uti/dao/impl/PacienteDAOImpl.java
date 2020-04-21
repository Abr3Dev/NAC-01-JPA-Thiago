package br.com.uti.dao.impl;

import javax.persistence.EntityManager;

import br.com.uti.dao.PacienteDAO;
import br.com.uti.entity.Paciente;
import br.com.uti.generic.GenericDAOImpl;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Long> implements PacienteDAO{

	public PacienteDAOImpl(EntityManager em) {
		super(em);
		
	}

}
