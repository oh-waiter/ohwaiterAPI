package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;
import java.text.DateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
public class Pagamento {
    @Id
    private Integer id;
    private String tipoDeCartao;
    @NotNull(message = "Selecione um bandeira válida")
    private String bandeiraDoCartao;
    @NotNull(message = "Número do cartão não inserido")
    private String numeroCartao;

    private DateFormat vencimentoDoCartao;
    private Integer cvv;
    private String nomeDoCartao;
    @CPF
    private String cpfCnpj;

}
