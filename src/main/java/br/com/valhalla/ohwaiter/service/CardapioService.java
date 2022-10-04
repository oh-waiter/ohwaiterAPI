package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Cardapio;
import br.com.valhalla.ohwaiter.repository.CardapioRepository;

@Service
public class CardapioService {
	
	private CardapioRepository cardapioRepository;
	
	@Autowired
	public CardapioService(CardapioRepository cardapioRepository) {
		this.cardapioRepository=cardapioRepository;
	}
	
	public Cardapio itemCardapio(Cardapio cardapio) {
		return cardapioRepository.save(cardapio);
		
	}
	
	public Cardapio buscarItemPorID(Long id) {
		return cardapioRepository.findById(id).orElse(null);
	}
	
	public List<Cardapio> buscarTodosOsItens(){
        return cardapioRepository.findAll();
	}
	
	public Cardapio alterarItemPorId(Long id){
        Cardapio item = cardapioRepository.findById(id).orElse(null);
        return cardapioRepository.save(item);
    }
	
	public void deletarItemPorId(Long id){
        cardapioRepository.deleteById(id);
    }

}
 