package br.com.faculdade.jsf_camisascriativas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.faculdade.jsf_camisascriativas.daos.FornecedorDao;
import br.com.faculdade.jsf_camisascriativas.models.Fornecedor;

@Model
@Transactional
public class FornecedorController {

	@Inject
	private FornecedorDao fornecedorDao;
	private Fornecedor fornecedor = new Fornecedor();
	private List<Fornecedor> fornecedores = new ArrayList<>();

	private Integer idToEdit;

	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	@PostConstruct
	private void postConstruct() {
		fornecedores.addAll(fornecedorDao.all());
	}

	public void loadDetails() {
		this.fornecedor = fornecedorDao.findById(idToEdit);
	}

	public String save() {
		fornecedorDao.save(fornecedor);
		return "/fornecedor/list?faces-redirect=true";
	}

	public String update(Integer id) {
		fornecedor.setId(id);
		fornecedorDao.update(fornecedor);
		return "/fornecedor/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Fornecedor fornecedor = fornecedorDao.findById(id);
		fornecedorDao.remove(fornecedor);
		return "/fornecedor/list?faces-redirect=true";
	}
}
