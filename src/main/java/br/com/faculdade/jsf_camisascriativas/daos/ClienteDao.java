package br.com.faculdade.jsf_camisascriativas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.faculdade.jsf_camisascriativas.models.Cliente;

public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Cliente> all() {
		return manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	public void save(Cliente cliente) {
		manager.persist(cliente);
	}

	public Cliente findById(Integer id) {
		return manager.find(Cliente.class, id);
	}

	public void remove(Cliente cliente) {
		manager.remove(cliente);
	}

	public void update(Cliente cliente) {
		manager.merge(cliente);
	}
}
