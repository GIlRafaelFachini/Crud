package br.com.curso.rest.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="alunos")
public class Aluno {
    @Id
    @GeneratedValue
    @Column(name ="codigo")
    private Long id;
    private String nome;
    private float media = 0;

}
