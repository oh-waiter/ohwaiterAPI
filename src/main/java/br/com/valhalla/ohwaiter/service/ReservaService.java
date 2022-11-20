package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.exceptions.ObjectNotFoundException;
import br.com.valhalla.ohwaiter.model.Reserva;
import br.com.valhalla.ohwaiter.model.Enums.Status;
import br.com.valhalla.ohwaiter.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> buscarTodasAsReserva() {
        return reservaRepository.findAll();
    }

    public List<Reserva> buscarReservasPorStatus(Status status) {
        return reservaRepository.findByStatus(status);
    }

    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva alterarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva alterarStatusReserva(String status, Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva == null) {
            throw new ObjectNotFoundException("Reserva não encontrado");
        }
        reserva.setStatus(Status.getEnum(status));
        return reservaRepository.save(reserva);
    }

    public void excluirReserva(Long id) {
        reservaRepository.deleteById(id);
    }

}
