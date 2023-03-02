package br.com.curso.rest.api.services;

import br.com.curso.rest.api.dtos.AlunoCreateDto;
import br.com.curso.rest.api.dtos.AlunoDto;
import br.com.curso.rest.api.dtos.AlunoUpDateDto;

import java.util.List;

public interface IAlunoCrudService {

    List<AlunoDto>listAlunos();
    AlunoDto createAluno(AlunoCreateDto alunoCreateDto);
    void upDateAluno(Long id, AlunoUpDateDto alunoUpDateDto);
    AlunoDto getAluno(Long id);
    void deleteAluno(Long id);
    public AlunoDto createDeAluno();
}
