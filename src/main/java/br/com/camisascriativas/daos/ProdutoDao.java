package br.com.camisascriativas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.camisascriativas.models.Produto;

public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Produto> all() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public void save(Produto produto) {
		manager.persist(produto);
	}

	public Produto findById(Integer id) {
		return manager.find(Produto.class, id);
	}

	public void remove(Produto produto) {
		manager.remove(produto);
	}

	public void update(Produto produto) {
		manager.merge(produto);
	}

}
