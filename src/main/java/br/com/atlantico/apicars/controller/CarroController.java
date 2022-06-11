package br.com.atlantico.apicars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlantico.apicars.controller.DTO.CarroDTO;
import br.com.atlantico.apicars.model.Carro;
import br.com.atlantico.apicars.repository.CarroRepository;

@RestController
@RequestMapping("/api")
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
	
	
	@GetMapping("/list")
	public List<CarroDTO> listar(){
		
		List<Carro> carros = carroRepository.findAll();
		return CarroDTO.converte(carros);
	}
}
