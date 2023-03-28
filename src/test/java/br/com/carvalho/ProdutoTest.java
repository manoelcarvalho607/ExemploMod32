/**
 * 
 */
package br.com.carvalho;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.util.List;

import org.junit.Test;

import br.com.carvalho.dao.ProdutoDao;
import br.com.carvalho.dao.IProdutoDao;
import br.com.carvalho.domain.Produto;


/**
 * @author manoel.carvalho
 *
 */
public class ProdutoTest {
	
	private IProdutoDao produtoDao;
	
	public ProdutoTest() {
		produtoDao = new ProdutoDao();
	}
	
	@Test
	public void cadastrar() {
		Produto produto = createProduto();
		produtoDao.cadastrar(produto);
		assertNotNull(produto.getId());
		
		produtoDao.excluir(produto);
		Produto prod2 = produtoDao.buscarPorId(produto.getId());
		assertNull(prod2);
		
	
	}
	
	
	
	@Test
	public void buscarMatriculaId() {
		Produto produto = createProduto();
		produtoDao.cadastrar(produto);
		
		Produto produtoDB = produtoDao.buscarPorId(produto.getId());
		assertNotNull(produtoDB);
		
		produtoDao.excluir(produto);
		Produto prod2 = produtoDao.buscarPorId(produto.getId());
		assertNull(prod2);
		
	}
	
	@Test
	public void buscarTodosMatricula() {
		Produto produto = createProduto();
		produtoDao.cadastrar(produto);
		
		List<Produto> produtoDB = produtoDao.buscarTodos();
		assertNotNull(produtoDB);
		
		produtoDao.excluir(produto);
		Produto prod3 = produtoDao.buscarPorId(produto.getId());
		assertNull(prod3);
		
	}
	
	@Test
	public void alterar() {
		Produto prod = createProduto();
		produtoDao.cadastrar(prod);
		
		Produto prodDB = produtoDao.buscarPorId(prod.getId());
		assertNotNull(prodDB);
		
		prodDB.setNome("PRODUTO2");;
		Produto prodUP = produtoDao.alterar(prodDB);
		assertEquals("PRODUTO2", prodUP.getNome());
		

		produtoDao.excluir(prod);
		Produto prod3 = produtoDao.buscarPorId(prod.getId());
		assertNull(prod3);
	}
	
	@Test
	public void excluir() {
		Produto prod = createProduto();
		produtoDao.cadastrar(prod);
		
		produtoDao.excluir(prod);
		Produto prod4 = produtoDao.buscarPorId(prod.getId());
		assertNull(prod4);
	}
	
	

	private Produto createProduto() {
		Produto produto = new Produto();
		produto.setCodigo("A1");
		produto.setNome("PRODUTO 1");
		produto.setDescricao("PRODUTO TESTE");
		
		
		return produto;
	}


}
