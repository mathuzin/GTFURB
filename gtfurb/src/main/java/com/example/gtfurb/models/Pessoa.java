package com.example.gtfurb.models;

import com.example.gtfurb.models.enums.TipoCurso;
import com.example.gtfurb.models.enums.TipoPessoa;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", nullable = false)
    private TipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_curso", nullable = true)
    private TipoCurso tipoCurso;

    @ManyToOne
    @JoinColumn(name = "id_orientador", nullable = true)
    private Pessoa orientador;

    @OneToMany(mappedBy = "orientador")
    private List<Pessoa> alunos;

    @PreRemove
    private void preRemove() {
        for (Pessoa aluno : alunos) {
            aluno.setOrientador(null);
        }
    }
}
