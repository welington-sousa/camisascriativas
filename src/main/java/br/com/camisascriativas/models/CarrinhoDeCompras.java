package br.com.camisascriativas.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("carrinho")
public class CarrinhoDeCompras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6616983944877189238L;

	private List<ItemCompra> itens;
	private BigDecimal total = BigDecimal.ZERO;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<ItemCompra>();
	}

	public void adiciona(ItemCompra item) {
		itens.add(item);
		total = total.add(item.getValor());
	}

	public int getTotalDeItens() {
		return getItens().size();
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<ItemCompra> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void remove(int indiceItem) {
		ItemCompra removido = itens.remove(indiceItem);
		total = total.subtract(removido.getValor());
	}
}