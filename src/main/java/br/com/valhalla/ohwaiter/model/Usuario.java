package br.com.valhalla.ohwaiter.model;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    private String nome;

    @NotNull(message = "CPF ou CNPJ obrigatorio e válido")
    @CNPJ
    @CPF
    private String cpfCnpj;

    public String getLogin(){
        return login;
    }




}
