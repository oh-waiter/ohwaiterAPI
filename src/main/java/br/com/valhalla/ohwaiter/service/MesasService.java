package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.exceptions.ResourceNotFoundException;
import br.com.valhalla.ohwaiter.model.Mesas;
import br.com.valhalla.ohwaiter.repository.MesasRepository;
@Service
public class MesasService {
	
	MesasRepository mesasRepository;
	
	
	@Autowired
	public MesasService(MesasRepository mesasrepository) {
		this.mesasRepository=mesasrepository;
	}
	
	public Mesas salvarMesa(Mesas mesas) {
		return mesasRepository.save(mesas);
	}
	
	public Mesas buscarMesasID(Long ID) {
		return mesasRepository.findById(ID).orElseThrow(()-> 
		new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
	}
	public List<Mesas> buscarMesas() {
		return mesasRepository.findAll();
	}
	
	public Mesas alterarMesasPorID(Mesas mesas) {
		Mesas entity = mesasRepository.findById(mesas.getID()).orElseThrow(()-> 
		new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		entity.setQtdCadeiras(mesas.getQtdCadeiras());
		entity.setDispoMesa(mesas.getDispoMesa());
		return mesasRepository.save(mesas);
	}
	
	public void deletarMesasPorID(Long ID) {
		Mesas entity = mesasRepository.findById(ID).orElseThrow(()-> 
		new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		mesasRepository.delete(entity);
	}

}
