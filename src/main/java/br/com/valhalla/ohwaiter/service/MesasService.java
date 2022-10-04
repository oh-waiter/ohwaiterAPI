package br.com.valhalla.ohwaiter.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.valhalla.ohwaiter.model.Mesas;
import br.com.valhalla.ohwaiter.repository.MesasRepository;

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
		return mesasRepository.findById(ID).orElse(null);
	}
	public List<Mesas> buscarMesas() {
		return mesasRepository.findAll();
	}
	
	public Mesas alterarMesasPorID(Long ID) {
		Mesas mesas = mesasRepository.findById(ID).orElse(null);
		return mesasRepository.save(mesas);
	}
	
	public void deletarMesasPorID(Long ID) {
		mesasRepository.deleteById(ID);
	}

}
