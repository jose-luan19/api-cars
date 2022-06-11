package br.com.atlantico.apicars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atlantico.apicars.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
