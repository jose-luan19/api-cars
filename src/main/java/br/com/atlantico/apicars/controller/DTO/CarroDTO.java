package br.com.atlantico.apicars.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.atlantico.apicars.model.Carro;
import br.com.atlantico.apicars.model.TipoCarro;

public class CarroDTO {
	
	private Long id;
	private String modelo;
	private Double kmL;
	private Integer capacidadeTanque;
	private Double qtsLitrosNoTanque;
	private Double velocidadeMedia;
	private Double autonomia;
	private TipoCarro tipoCarro;
	
	public CarroDTO(Carro carro) {
		this.id = carro.getId();
		this.modelo = carro.getModelo();
		this.kmL = carro.getKmL();
		this.capacidadeTanque = carro.getCapacidadeTanque();
		this.qtsLitrosNoTanque = carro.getQtsLitrosNoTanque();
		this.velocidadeMedia = carro.getVelocidadeMedia();
		this.tipoCarro = carro.getTipoCarro();
		this.autonomia = carro.getAutonomia();
	}
	
	public Long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public Double getKmL() {
		return kmL;
	}

	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public Double getQtsLitrosNoTanque() {
		return qtsLitrosNoTanque;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public Double getAutonomia() {
		return autonomia;
	}

	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}

	public static List<CarroDTO> converte(List<Carro> carro) {
		return carro.stream().map(CarroDTO::new).collect(Collectors.toList());
	}
	
}
