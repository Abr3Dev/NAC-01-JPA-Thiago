package br.com.fiap.jpa.uti.dao;

import br.com.fiap.jpa.uti.exception.CommitException;
import br.com.fiap.jpa.uti.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void atualizar(T entity);

	void deletar(K id) throws KeyNotFoundException;

	T pesquisar(K id) throws KeyNotFoundException;

	void commit() throws CommitException;

}
