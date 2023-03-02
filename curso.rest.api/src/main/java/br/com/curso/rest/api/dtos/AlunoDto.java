package br.com.curso.rest.api.dtos;

import br.com.curso.rest.api.model.Aluno;
import lombok.Data;

@Data
public class AlunoDto {
    private Long id;
    private String nome;
    private Boolean aprovado;

    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.aprovado = aluno.getMedia() > 6;
    }
}
