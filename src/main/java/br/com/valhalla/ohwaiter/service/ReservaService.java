package br.com.valhalla.ohwaiter.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.exceptions.ObjectNotFoundException;
import br.com.valhalla.ohwaiter.model.Reserva;
import br.com.valhalla.ohwaiter.model.Enums.Status;
import br.com.valhalla.ohwaiter.repository.ClienteRepository;
import br.com.valhalla.ohwaiter.repository.MesaRepository;
import br.com.valhalla.ohwaiter.repository.PratoRepository;
import br.com.valhalla.ohwaiter.repository.ReservaRepository;
import br.com.valhalla.ohwaiter.resource.DTO.ReservaDTO;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private PratoRepository pratoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Reserva> buscarTodasAsReserva() {
        return reservaRepository.findAll();
    }

    public List<Reserva> buscarReservasPorStatus(Status status) {
        return reservaRepository.findByStatus(status);
    }

    public Reserva salvarReserva(ReservaDTO reservaDto) {
        Reserva reserva = new Reserva();

        reserva.setMesas(mesaRepository.findByIdList(reservaDto.getMesas()));
        reserva.setPrato(pratoRepository.findByIdList(reservaDto.getPrato()));
        reserva.setCliente(clienteRepository.findByCpf(reservaDto.getCliente()));
        reserva.setStatus(Status.ABERTO);
        reserva.setReserva(criarReserva());
        reserva.getMesas().forEach(mesa -> {
            mesa.setDisponibilidadeMesa(false);
            mesaRepository.save(mesa);
        });

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

    private String criarReserva() {
        Random random = new Random();
        String reserva = "RE";
        reserva = reserva + (random.nextInt(100000000));
        while (reservaRepository.findByReserva(reserva).isPresent()) {
            reserva = "RE";
            reserva = reserva + (random.nextInt(100000000));
        }
        return reserva;
    }

}
