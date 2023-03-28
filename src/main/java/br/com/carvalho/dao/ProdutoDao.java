/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carvalho.domain.Produto;


/**
 * @author manoel.carvalho
 *
 */
public class ProdutoDao implements IProdutoDao {

	@Override
	public Produto cadastrar(Produto prod) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(prod);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return prod;
	}

	@Override
	public Produto buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Produto prod = entityManager.find(Produto.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return prod;
	}

	@Override
	public void excluir(Produto produto) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public Produto alterar(Produto prod) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		prod = entityManager.merge(prod);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return prod;
	}

	@Override
	public List<Produto> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Produto> list = 
				entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

}
