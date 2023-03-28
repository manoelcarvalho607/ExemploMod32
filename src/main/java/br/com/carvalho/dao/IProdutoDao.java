/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import br.com.carvalho.domain.Produto;


/**
 * @author manoel.carvalho
 *
 */
public interface IProdutoDao {
	
	public Produto cadastrar(Produto curso);
	Produto buscarPorId(Long id);
	public void excluir(Produto curso);
	public Produto alterar(Produto curso);
	public List<Produto> buscarTodos();

}
