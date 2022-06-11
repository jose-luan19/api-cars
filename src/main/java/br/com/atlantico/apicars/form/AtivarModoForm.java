package br.com.atlantico.apicars.form;

public class AtivarModoForm {
	
	private String modelo;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public AtivarModoForm(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "AtivarModoForm [modelo=" + modelo + "]";
	}

	public AtivarModoForm() {
	}

		

}
