package br.com.camisascriativas.models;

import java.math.BigDecimal;

public class ItemCompra {

	private Camisa camisa;
	private int quantidade;
	private Cor cor;

	public ItemCompra() {
	}

	public ItemCompra(Camisa camisa, int quantidade) {
		super();
		this.camisa = camisa;
		this.quantidade = quantidade;
	}

	public void setCamisa(Camisa camisa) {
		this.camisa = camisa;
	}

	public Camisa getCamisa() {
		return camisa;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return camisa.getValorUnitario().multiply(new BigDecimal(quantidade));
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
}