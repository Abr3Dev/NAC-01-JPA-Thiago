package br.com.uti.generic;

import br.com.uti.exception.CommitException;
import br.com.uti.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void atualizar(T entity);

	void deletar(K id) throws KeyNotFoundException;

	T pesquisar(K id) throws KeyNotFoundException;

	void commit() throws CommitException;

}
