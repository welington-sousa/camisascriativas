package br.com.camisascriativas.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Camisa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Column(length = 1000)
	private String descricao;
	private BigDecimal valorUnitario;

	public Camisa() {
	}

	public Camisa(String descricao, BigDecimal valorUnitario) {
		super();
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
}