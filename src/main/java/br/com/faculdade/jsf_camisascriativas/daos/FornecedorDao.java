package br.com.faculdade.jsf_camisascriativas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.faculdade.jsf_camisascriativas.models.Fornecedor;

public class FornecedorDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Fornecedor> all() {
		return manager.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
	}

	public void save(Fornecedor fornecedor) {
		manager.persist(fornecedor);
	}

	public Fornecedor findById(Integer id) {
		return manager.find(Fornecedor.class, id);
	}

	public void remove(Fornecedor fornecedor) {
		manager.remove(fornecedor);
	}

	public void update(Fornecedor fornecedor) {
		manager.merge(fornecedor);
	}
}
