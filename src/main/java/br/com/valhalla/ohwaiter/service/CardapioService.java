package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.valhalla.ohwaiter.exceptions.ResourceNotFoundException;
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
	
	public Cardapio alterarItemCardapio(Cardapio cardapio){
		Cardapio entity = cardapioRepository.findById(cardapio.getID()).orElseThrow(()->
		new ResourceAccessException("Nenhum registro encontrado para este ID!"));
		entity.setTipoItem(cardapio.getTipoItem());
		entity.setDescItem(cardapio.getDescItem());
		entity.setValorItem(cardapio.getValorItem());
		entity.setIDCategoria(cardapio.getIDCategoria());
        return cardapioRepository.save(cardapio);
    }
	
	public void deletarItemPorId(Long id){
		Cardapio entity = cardapioRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        cardapioRepository.delete(entity);
    }

}
 