package br.com.valhalla.ohwaiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.ohwaiter.model.Reserva;
import br.com.valhalla.ohwaiter.model.Enums.Status;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByStatus(Status status);
}
