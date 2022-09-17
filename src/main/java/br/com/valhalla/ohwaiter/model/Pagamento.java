package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;
import java.text.DateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Seleciona um tipo de cartão válido")
    private String tipoDeCartao;
    @NotNull(message = "Selecione uma bandeira válida")
    private String bandeiraDoCartao;
    @NotNull(message = "Número do cartão não inserido")
    @CreditCardNumber(message = "Número do cartão inválido")
    private String numeroCartao;
    @NotNull(message = "A data de vencimento do cartão deve ser válida")
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "O formato deve ser MM/YY")
    private String dataExpiracao;
    @NotNull(message = "CCV não pode ser vazio")
    @Digits(integer = 3,fraction = 0,message = "CCV Inválido")
    private String ccv;
    private String nomeDoCartao;
    @NotNull(message = "CPF ou CNPJ obrigatorio e válido")
    @CNPJ
    @CPF
    private String cpfCnpj;

}
