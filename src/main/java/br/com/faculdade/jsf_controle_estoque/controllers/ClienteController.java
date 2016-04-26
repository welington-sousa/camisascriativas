package br.com.faculdade.jsf_controle_estoque.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.faculdade.jsf_controle_estoque.daos.ClienteDao;
import br.com.faculdade.jsf_controle_estoque.models.Cliente;

@Model
@Transactional
public class ClienteController {

	@Inject
	private ClienteDao clienteDao;
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<>();

	private Integer idToEdit;

	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@PostConstruct
	private void postConstruct() {
		clientes.addAll(clienteDao.all());
	}

	public void loadDetails() {
		this.cliente = clienteDao.findById(idToEdit);
	}

	public String save() {
		clienteDao.save(cliente);
		return "/cliente/list?faces-redirect=true";
	}

	public String update(Integer id) {
		cliente.setId(id);
		clienteDao.update(cliente);
		return "/cliente/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Cliente cliente = clienteDao.findById(id);
		clienteDao.remove(cliente);
		return "/cliente/list?faces-redirect=true";
	}
}
