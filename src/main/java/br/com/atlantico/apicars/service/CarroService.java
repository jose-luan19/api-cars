package br.com.atlantico.apicars.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.atlantico.apicars.model.Carro;
import br.com.atlantico.apicars.model.TipoCarro;

@Service
public class CarroService {

	public List<Carro> listarCarros(Carro polo, Carro gol, Carro fox, Carro civic, Carro jeep, Carro corola) {
		return Arrays.asList(polo, gol, fox, civic, jeep, corola);
	}

	public Object abastecerCarro(String modelo, Double quantidadeAbestecida, List<Carro> carros) {

		for (Carro carro : carros) {
			if (carro.getModelo().equals(modelo)) {
				carro.setQtsLitrosNoTanque(quantidadeAbestecida);
				return carro;
			}
		}
		return null;
	}

	public List<Carro> guardarCarros(Carro polo, Carro gol, Carro fox, Carro civic, Carro jeep, Carro corola) {
		List<Carro> carros = new ArrayList<>();
		carros.add(polo);
		carros.add(gol);
		carros.add(fox);
		carros.add(jeep);
		carros.add(civic);
		carros.add(corola);
		return carros;
	}

	public String erro(String message) {
		return "[message=" + message + "]";
	}

	public Object ativarTurbo(String modelo, List<Carro> carros) {
		for (Carro carro : carros) {
			if (carro.getModelo().equals(modelo) && carro.getTipoCarro().equals(TipoCarro.TURBO)) {
				carro.ativarTurbo();
				return carro;
			}
		}

		return null;
	}

	public Object ativarEconomico(String modelo, List<Carro> carros) {
		for (Carro carro : carros) {
			if (carro.getModelo().equals(modelo) && carro.getTipoCarro().equals(TipoCarro.ECONOMICO)) {
				carro.ativarEconomico();
				return carro;
			}
		}

		return null;
	}

	public Carro carroMaiorAutonomia(List<Carro> carros) {
		Double maior = 0D;
		Carro carroMaiorAutonomia = null;

		for (Carro carro : carros) {
			if (carro.getAutonomia() > maior) {
				maior = carro.getAutonomia();
				carroMaiorAutonomia = carro;
			}
		}
		return carroMaiorAutonomia;

	}

}
