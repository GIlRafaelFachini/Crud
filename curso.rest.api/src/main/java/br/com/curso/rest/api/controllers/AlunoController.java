package br.com.curso.rest.api.controllers;

import br.com.curso.rest.api.dtos.AlunoCreateDto;
import br.com.curso.rest.api.dtos.AlunoDto;
import br.com.curso.rest.api.dtos.AlunoUpDateDto;
import br.com.curso.rest.api.services.IAlunoCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {

    private IAlunoCrudService iAlunoCrudService;

    public AlunoController(IAlunoCrudService iAlunoCrudService) {

        this.iAlunoCrudService = iAlunoCrudService;

    }

    @GetMapping("/alunos")
    public List<AlunoDto> listAlunos() {
        return this.iAlunoCrudService.listAlunos();
    }

    @PostMapping("/alunos")
    public AlunoDto createAluno(@RequestBody AlunoCreateDto alunoCreateDto) {
        return this.iAlunoCrudService.createAluno(alunoCreateDto);
    }

    @PutMapping("/alunos/{id}")
    public void upDateAluno(@PathVariable Long id, @RequestBody AlunoUpDateDto alunoUpDateDto) {
        this.iAlunoCrudService.upDateAluno(id, alunoUpDateDto);
    }

    @GetMapping("/alunos/{id}")
    public AlunoDto getAluno(@PathVariable Long id){
        return this.iAlunoCrudService.getAluno(id);
    }

    @DeleteMapping ("/alunos/{id}")
    void deleteAluno(@PathVariable Long id){
        this.iAlunoCrudService.deleteAluno(id);
    }

}
