package br.com.valhalla.ohwaiter.resource.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.model.Enums.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String funcao;
    private Boolean ativo;

    public static FuncionarioDTO modelToDto(Funcionario funcionario) {
        return FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .cpf(funcionario.getCpf())
                .ativo(funcionario.getAtivo())
                .funcao(funcionario.getFuncao().getDescricao())
                .build();
    }

    public static List<FuncionarioDTO> modelToDto(List<Funcionario> funcionarios) {
        List<FuncionarioDTO> dtos = new ArrayList<>();
        funcionarios.forEach(funcionario -> {
            dtos.add(FuncionarioDTO.builder()
                    .id(funcionario.getId())
                    .nome(funcionario.getNome())
                    .cpf(funcionario.getCpf())
                    .ativo(funcionario.getAtivo())
                    .funcao(funcionario.getFuncao().getDescricao())
                    .build());
        });
        return dtos;
    }

    public static Funcionario DtoToModel(FuncionarioDTO funcionarioDto) {
        return Funcionario.builder()
                .id(funcionarioDto.getId())
                .nome(funcionarioDto.getNome())
                .cpf(funcionarioDto.getCpf())
                .ativo(funcionarioDto.getAtivo())
                .funcao(Funcao.getEnum(funcionarioDto.getFuncao()))
                .build();
    }

}
