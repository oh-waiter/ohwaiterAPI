package br.com.valhalla.ohwaiter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.valhalla.ohwaiter.model.Prato;
import br.com.valhalla.ohwaiter.repository.EstoqueRepository;
import br.com.valhalla.ohwaiter.repository.PratoRepository;
import br.com.valhalla.ohwaiter.resource.DTO.IngredienteDTO;
import br.com.valhalla.ohwaiter.resource.DTO.PratoDTO;

public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Prato salvarPrato(PratoDTO pratoDto){
        Prato prato = Prato.builder().nome(pratoDto.getNome()).tempoPreparo(pratoDto.getTempoPreparo())
                .ingredientes(estoqueRepository.findByNomeList(dtoIngredienteToString(pratoDto.getIngredientes()))).build();

        return pratoRepository.save(prato);
    }

    public Prato alterarPrato(Prato prato){
        return pratoRepository.save(prato);
    }

    public List<Prato> pegarTodosOsPratos(){
        return pratoRepository.findAll();
    }

    public Prato pegarUmPratoPorId(Long id){
        return pratoRepository.findById(id).orElse(new Prato());
    }

    public List<Prato> pegarApenasPratosSelecionados(List<Long> ids){
        return pratoRepository.findByIdList(ids);
    }

    public void excluirPrato(Long id){
        pratoRepository.deleteById(id);
    }
    
    private List<String> dtoIngredienteToString(List<IngredienteDTO> ingredientes){
        List<String> nomesIngredientes = new ArrayList<>();
        ingredientes.forEach(ingrediente -> {
            nomesIngredientes.add(ingrediente.getNome());
        });

        return nomesIngredientes;
    }
}
