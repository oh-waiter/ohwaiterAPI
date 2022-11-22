package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.exceptions.ResourceNotFoundException;
import br.com.valhalla.ohwaiter.model.Mesa;
import br.com.valhalla.ohwaiter.repository.MesaRepository;

@Service
public class MesaService {

	MesaRepository mesaRepository;

	@Autowired
	public MesaService(MesaRepository mesarepository) {
		this.mesaRepository = mesarepository;
	}

	public Mesa salvarMesa(Mesa mesa) {
		return mesaRepository.save(mesa);
	}

	public Mesa buscarMesaID(Long ID) {
		return mesaRepository.findById(ID)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
	}

	public List<Mesa> buscarMesa() {
		return mesaRepository.findAll();
	}

	public Mesa alterarMesaPorID(Mesa mesa) {
		Mesa entity = mesaRepository.findById(mesa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		entity.setQuantidadeCarteiras(mesa.getQuantidadeCarteiras());
		entity.setDisponibilidadeMesa(mesa.getDisponibilidadeMesa());
		return mesaRepository.save(mesa);
	}

	public void deletarMesaPorID(Long ID) {
		Mesa entity = mesaRepository.findById(ID)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		mesaRepository.delete(entity);
	}

}
