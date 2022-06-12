package br.com.atlantico.apicars.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.atlantico.apicars.model.Carro;

public class AutonomiaCarrosDTO {
	
	private String modelo;
	private Double autonomia;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}
	public AutonomiaCarrosDTO(Carro carro) {
		this.modelo = carro.getModelo();
		this.autonomia = carro.getAutonomia();
	}
	@Override
	public String toString() {
		return "AutonomiaCarrosDTO [modelo=" + modelo + ", autonomia=" + autonomia + "]";
	}
	
	public static List<AutonomiaCarrosDTO> converte(List<Carro> carros) {
		return carros.stream().map(AutonomiaCarrosDTO::new).collect(Collectors.toList());
	}

}
