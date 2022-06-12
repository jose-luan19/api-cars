package br.com.atlantico.apicars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlantico.apicars.controller.DTO.AutonomiaCarrosDTO;
import br.com.atlantico.apicars.form.AbastecimentoForm;
import br.com.atlantico.apicars.form.AtivarModoForm;
import br.com.atlantico.apicars.model.Carro;
import br.com.atlantico.apicars.model.TipoCarro;
import br.com.atlantico.apicars.service.CarroService;

@RestController
@RequestMapping("/api")
public class CarroController {

	@Autowired
	private CarroService carroService;

	Carro polo = new Carro(1L, "Polo", 10.5D, 90, 70D, 65.7D, TipoCarro.TURBO);
	Carro gol = new Carro(2L, "Gol", 14D, 96, 50D, 80D, TipoCarro.ECONOMICO);
	Carro fox = new Carro(3L, "Fox", 12D, 100, 40D, 50D, TipoCarro.BASICO);
	Carro civic = new Carro(4L, "Civic", 8D, 111, 45D, 70D, TipoCarro.TURBO);
	Carro jeep = new Carro(5L, "Jeep", 16D, 80, 67D, 90.2D, TipoCarro.ECONOMICO);
	Carro corola = new Carro(6L, "Corola", 15D, 75, 20D, 42.5D, TipoCarro.BASICO);
	

	@GetMapping("/list")
	public List<Carro> listar() {
		return carroService.listarCarros(polo, gol, fox, civic, jeep, corola);
	}

	@PutMapping(path = "/abastecer", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> abastecerPorModelo(@RequestBody AbastecimentoForm carroAbastecendo) {

		List<Carro> carros = carroService.guardarCarros(polo, gol, fox, civic, jeep, corola);
		Object tentativaDeAbastecimento = carroService.abastecerCarro(carroAbastecendo.getModelo(),
				carroAbastecendo.getQuantidadeAbestecida(), carros);
		if (tentativaDeAbastecimento != null) {
			Carro carroAbastecido = (Carro) tentativaDeAbastecimento;
			return ResponseEntity.status(HttpStatus.OK).body(carroAbastecido);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/list-autonomia")
	public List<AutonomiaCarrosDTO> listarAutonomia() {
		return AutonomiaCarrosDTO.converte(carroService.guardarCarros(polo, gol, fox, civic, jeep, corola));
	}

	@PutMapping(path = "/ativar-turbo", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> ativarModoTurbo(@RequestBody AtivarModoForm ativarCarro) {

		List<Carro> carros = carroService.guardarCarros(polo, gol, fox, civic, jeep, corola);
		Object tentativaAtivacaoTurbo = carroService.ativarTurbo(ativarCarro.getModelo(),carros);
		if(tentativaAtivacaoTurbo != null) {
			Carro carroAtivado = (Carro) tentativaAtivacaoTurbo;
			return ResponseEntity.status(HttpStatus.OK).body(carroAtivado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/ativar-economico", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> ativarModoEconomico(@RequestBody AtivarModoForm ativarCarro) {
		
		List<Carro> carros = carroService.guardarCarros(polo, gol, fox, civic, jeep, corola);
		Object tentativaAtivacaoTurbo = carroService.ativarEconomico(ativarCarro.getModelo(),carros);
		if(tentativaAtivacaoTurbo != null) {
			Carro carroAtivado = (Carro) tentativaAtivacaoTurbo;
			return ResponseEntity.status(HttpStatus.OK).body(carroAtivado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/maior-autonomia")
	public Carro maiorAutonomia() {
		return carroService.carroMaiorAutonomia(carroService.guardarCarros(polo, gol, fox, civic, jeep, corola));
	}
}
