package br.com.camisascriativas.models;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

@Named("cor")
public class Cor {

	private String verde = "verde";
	private String vermelha = "vermelha";
	private String azul = "azul";

	public List<String> cores() {
		List<String> lista = Arrays.asList(verde, vermelha, azul);
		return lista;
	}

	public String getVerde() {
		return verde;
	}

	public void setVerde(String verde) {
		this.verde = verde;
	}

	public String getVermelha() {
		return vermelha;
	}

	public void setVermelha(String vermelha) {
		this.vermelha = vermelha;
	}

	public String getAzul() {
		return azul;
	}

	public void setAzul(String azul) {
		this.azul = azul;
	}

	// @Override
	// public String toString() {
	// return cores().get(0).toString() + "\n" + cores().get(1).toString() +
	// "\n" + cores().get(2).toString();
	// }

	// @Override
	// public String toString() {
	// return verde + vermelha + azul;
	// }
}