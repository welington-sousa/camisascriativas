package br.com.faculdade.jsf_camisascriativas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.faculdade.jsf_camisascriativas.daos.FornecedorDao;
import br.com.faculdade.jsf_camisascriativas.daos.ProdutoDao;
import br.com.faculdade.jsf_camisascriativas.models.Fornecedor;
import br.com.faculdade.jsf_camisascriativas.models.Produto;

@Model
@Transactional
public class ProdutosController {

	@Inject
	private ProdutoDao produtoDao;
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();

	@Inject
	private FornecedorDao categoriaDao;
	private List<Fornecedor> fornecedores = new ArrayList<>();

	private Integer idToEdit;

	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	@PostConstruct
	private void postConstruct() {
		produtos.addAll(produtoDao.all());
		fornecedores.addAll(categoriaDao.all());
		produto.setFornecedor(new Fornecedor());
	}

	public void loadDetails() {
		this.produto = produtoDao.findById(idToEdit);
	}

	public String save() {
		produtoDao.save(produto);
		return "/produtos/list?faces-redirect=true";
	}

	public String update(Integer id) {
		produto.setId(id);
		produtoDao.update(produto);
		return "/produtos/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Produto product = produtoDao.findById(id);
		produtoDao.remove(product);
		return "/produtos/list?faces-redirect=true";
	}

}
