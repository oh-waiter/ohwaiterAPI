package br.com.valhalla.ohwaiter.service;
import java.util.List;

import br.com.valhalla.ohwaiter.model.Pagamento;
import br.com.valhalla.ohwaiter.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;

@Service
public class PagamentoService {
    private CartaoRepository cartaoRepository;

    @Autowired
    public PagamentoService(CartaoRepository cartaoRepository){
        this.cartaoRepository = cartaoRepository;
    }

    public Pagamento salvarCartao(Pagamento cartoes){
        return cartaoRepository.save(cartoes);
    }
    public Pagamento buscarCartaoPorId(Long id){
        return cartaoRepository.findById(id).orElse(null);
    }

    public List<Pagamento> buscarTodosOsCartoes(){
        return cartaoRepository.findAll();
    }

    public Pagamento alterarCartaoPorId(Long id){
        Pagamento cartao = cartaoRepository.findById(id).orElse(null);
        return cartaoRepository.save(cartao);
    }

    public void deletarCartaoPorId(Long id){
        cartaoRepository.deleteById(id);
    }


}
