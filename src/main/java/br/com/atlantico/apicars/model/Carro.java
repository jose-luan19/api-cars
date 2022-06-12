package br.com.atlantico.apicars.model;

//@Entity
public class Carro {
	
	//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private Double kmL;
	private Integer capacidadeTanque;
	private Double qtsLitrosNoTanque;
	private Double velocidadeMedia;
//	@Column(columnDefinition = "double AS (kmL*qtsLitrosNoTanque) precision", insertable = false, updatable = false)
	private Double autonomia;
//	@Enumerated(EnumType.STRING)
	private TipoCarro tipoCarro;
	private Boolean modoAtivado = false;
	
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
		if(this.tipoCarro == TipoCarro.ECONOMICO && this.modoAtivado == true) {
			this.kmL = this.kmL + (this.kmL * 0.1D);
		}
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
	public void setQtsLitrosNoTanque(Double quantidadeAbestecida) {
		this.qtsLitrosNoTanque = this.qtsLitrosNoTanque + quantidadeAbestecida;
		if(this.qtsLitrosNoTanque > this.capacidadeTanque) {
			this.qtsLitrosNoTanque = this.capacidadeTanque.doubleValue();
		}
	}
	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
		if(this.tipoCarro == TipoCarro.ECONOMICO && this.modoAtivado == true) {
			this.autonomia = this.autonomia + (this.autonomia * 0.05D);
		}
	}
	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}
	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}
	public Boolean getModoAtivado() {
		return modoAtivado;
	}
	public void setModoAtivado(Boolean modoAtivado) {
		this.modoAtivado = modoAtivado;
	}
	
	public Carro(Long id, String modelo, Double kmL, Integer capacidadeTanque, Double qtsLitrosNoTanque,
			Double velocidadeMedia, TipoCarro tipoCarro) {
		this.id = id;
		this.modelo = modelo;
		this.kmL = kmL;
		this.capacidadeTanque = capacidadeTanque;
		this.qtsLitrosNoTanque = qtsLitrosNoTanque;
		this.velocidadeMedia = velocidadeMedia;
		this.autonomia = kmL * qtsLitrosNoTanque;
		this.tipoCarro = tipoCarro;
		this.modoAtivado = getModoAtivado();
	}
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", kmL=" + kmL + ", capacidadeTanque=" + capacidadeTanque
				+ ", qtsLitrosNoTanque=" + qtsLitrosNoTanque + ", velocidadeMedia=" + velocidadeMedia + ", autonomia="
				+ autonomia + ", tipoCarro=" + tipoCarro + ", modoAtivado=" + modoAtivado + "]";
	}
	public void ativarTurbo() {
		setVelocidadeMedia(getVelocidadeMedia() + getVelocidadeMedia()*0.15D);
		setKmL(getKmL()-getKmL()* 0.3D);
		setModoAtivado(true);
	}
	
	public void ativarEconomico() {
		setAutonomia(getAutonomia() + getAutonomia() * 0.05D);
		setKmL(getKmL()+getKmL() * 0.1D);
		setModoAtivado(true);
	}
	
}
