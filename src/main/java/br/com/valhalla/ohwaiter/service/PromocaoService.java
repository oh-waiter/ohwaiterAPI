package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Promocao;
import br.com.valhalla.ohwaiter.repository.PromocaoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j()
public class PromocaoService {
    
private PromocaoRepository promocaoRepository;

    @Autowired
    public PromocaoService(PromocaoRepository promocaoRepository){
      this.promocaoRepository = promocaoRepository;  
    }

    public Promocao salvarPromocao(Promocao promocao){
        log.info("Service: Inicio da serviço de salvar Promoção");
        try{
            log.debug("Service: Promoção adicionada {}", promocao );
            return promocaoRepository.save(promocao);
        } catch (Exception erro){
            log.error("Service: Erro desconhecido ao salvar a Promoção {}", erro);
            return null;
        }   
    }

    public List<Promocao> buscarTodasAsPromocoes(){
        log.info("Service: Inicio da serviço de buscar todas as Promoções");
        return promocaoRepository.findAll();
    }


    public Promocao alterarPromocaoPorId(Promocao promocao){
        log.info("Service: Início da service de alterar Promoção por Id");
        try {
            log.debug("Service: Promoção alterada com sucesso {}", promocao);
            return promocaoRepository.save(promocao);
        } catch (Exception erro) {
            log.error("Service: Erro ao alterar a Promoção{}", erro);
            return null;
        }
    }

    public void deletarPromocaoPorId(Long id){
        log.info("Service: Inicio do serviço de excluir a Promoção por Id");
        try {
            log.info("Service: Id da Promoção que será excluída {}", id);
            promocaoRepository.deleteById(id);
        } catch (Exception erro) {
            log.error("Service: Erro ao excluir a Promoção {}", erro);
        }
    }
}
