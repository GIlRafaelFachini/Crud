package br.com.curso.rest.api.repositories;

import br.com.curso.rest.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<Aluno,Long> {
}
