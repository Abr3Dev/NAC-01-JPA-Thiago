package br.com.fiap.jpa.uti.dao;

import java.util.List;

import br.com.fiap.jpa.uti.dao.GenericDAO;
import br.com.fiap.jpa.uti.entity.Endereco;

public interface EnderecoDAO extends GenericDAO<Endereco, Long>{

	void cadastrar(List<Endereco> ends);

}
