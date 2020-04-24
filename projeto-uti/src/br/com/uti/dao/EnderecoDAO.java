package br.com.uti.dao;

import java.util.List;

import br.com.uti.entity.Endereco;
import br.com.uti.generic.GenericDAO;

public interface EnderecoDAO extends GenericDAO<Endereco, Long>{

	void cadastrar(List<Endereco> ends);

}
