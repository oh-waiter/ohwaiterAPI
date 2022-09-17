package br.com.valhalla.ohwaiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio,Integer> {

}
