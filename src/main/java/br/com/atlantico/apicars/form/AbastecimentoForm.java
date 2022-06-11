package br.com.atlantico.apicars.form;

public class AbastecimentoForm {
	
	
	private String modelo;
	private Double quantidadeAbestecida;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getQuantidadeAbestecida() {
		return quantidadeAbestecida;
	}
	public void setQuantidadeAbestecida(Double quantidadeAbestecida) {
		this.quantidadeAbestecida = quantidadeAbestecida;
	}

	public AbastecimentoForm(String modelo, Double quantidadeAbestecida) {
		this.modelo = modelo;
		this.quantidadeAbestecida = quantidadeAbestecida;
	} 
	
	@Override
	public String toString() {
		return "AbastecimentoForm [modelo=" + modelo + ", quantidadeAbestecida=" + quantidadeAbestecida + "]";
	}


}
