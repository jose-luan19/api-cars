package br.com.atlantico.apicars.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private Double kmL;
	private Integer capacidadeTanque;
	private Double qtsLitrosNoTanque;
	private Double velocidadeMedia;
//	@Column(columnDefinition = "double AS (kmL*qtsLitrosNoTanque) precision", insertable = false, updatable = false)
	private Double autonomia;
	@Enumerated(EnumType.STRING)
	private TipoCarro tipoCarro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getKmL() {
		return kmL;
	}
	public void setKmL(Double kmL) {
		this.kmL = kmL;
	}
	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	public Double getQtsLitrosNoTanque() {
		return qtsLitrosNoTanque;
	}
	public void setQtsLitrosNoTanque(Double qtsLitrosNoTanque) {
		this.qtsLitrosNoTanque = qtsLitrosNoTanque;
	}
	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
	@PrePersist
	public void prePersist() {
	    if(autonomia == null) //We set default value in case if the value is not set yet.
	    	autonomia = this.kmL * this.qtsLitrosNoTanque;
	}
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}
	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}
	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}

}
