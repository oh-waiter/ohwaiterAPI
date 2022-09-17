package br.com.valhalla.ohwaiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Mesas;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Integer>{

}
