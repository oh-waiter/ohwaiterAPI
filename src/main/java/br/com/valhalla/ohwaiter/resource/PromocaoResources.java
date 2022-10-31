package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Promocao;
import br.com.valhalla.ohwaiter.resource.DTO.PromocaoDTO;
import br.com.valhalla.ohwaiter.service.PromocaoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("promocao")
@Slf4j
public class PromocaoResources {

    private PromocaoService promocaoService;

    @Autowired
    public PromocaoResources(PromocaoService promocaoService) {
        this.promocaoService = promocaoService;
    }

    @GetMapping()
    public List<PromocaoDTO> buscarTodasAsPromocoes() {
        log.info("Resource: Pegando a lista de promocoes");
        List<PromocaoDTO> promocaoDtos = PromocaoDTO.modelToDto(promocaoService.buscarTodasAsPromocoes());
        return promocaoDtos;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Promocao salvarPromocao(@RequestBody PromocaoDTO promocaoDto) {
        log.info("Resource: Salvando Promoções {}", promocaoDto);
        Promocao promocao = PromocaoDTO.DtoToModel(promocaoDto);
        return promocaoService.salvarPromocao(promocao);
    }

    @DeleteMapping("/{id}")
    public void excluirPromocao(@PathVariable Long id) {
        log.info("Resource: Excluindo Promoções {}", id);
        promocaoService.deletarPromocaoPorId(id);
    }

}
