package br.com.curso.rest.api.services;

import br.com.curso.rest.api.dtos.AlunoCreateDto;
import br.com.curso.rest.api.dtos.AlunoDto;
import br.com.curso.rest.api.dtos.AlunoUpDateDto;
import br.com.curso.rest.api.model.Aluno;
import br.com.curso.rest.api.repositories.IAlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoCrudService implements IAlunoCrudService {
    private IAlunoRepository repository;

    public AlunoCrudService(IAlunoRepository repository) {
        this.repository = repository;
    }

    public List<AlunoDto> listAlunos() {

        List<AlunoDto> alunosDtos = new ArrayList<>();
        List<Aluno> alunos = repository.findAll();

        for (Aluno aluno : alunos) {
            AlunoDto alunoDto = new AlunoDto(aluno);
            alunosDtos.add(alunoDto);
        }
        return alunosDtos;
    }

    public AlunoDto createAluno(AlunoCreateDto alunoCreateDto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoCreateDto.getNome());
        aluno = repository.save(aluno);
        AlunoDto alunoDto = new AlunoDto(aluno);
        return alunoDto;
    }

    public void upDateAluno(Long id, AlunoUpDateDto alunoUpDateDto) {

        Optional<Aluno> alunoOptional = this.repository.findById(id);

        if (alunoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado" + id);
        }
        Aluno aluno = alunoOptional.get();
        aluno.setNome(alunoUpDateDto.getNome());
        aluno.setMedia(alunoUpDateDto.getMedia());

        this.repository.save(aluno);
    }

    public AlunoDto getAluno(Long id) {
        Optional<Aluno> alunoOptional = this.repository.findById(id);

        if (alunoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }
        Aluno aluno = alunoOptional.get();
        AlunoDto alunoDto = new AlunoDto(aluno);

        return alunoDto;
    }

    public void deleteAluno(Long id){

        Optional<Aluno> alunoOptional = this.repository.findById(id);

        if (alunoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }

        Aluno aluno = alunoOptional.get();
        this.repository.delete(aluno);
    }

    @Override
    public AlunoDto createDeAluno() {
        return null;
    }

}
