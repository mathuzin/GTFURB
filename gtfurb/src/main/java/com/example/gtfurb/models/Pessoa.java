package com.example.gtfurb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.gtfurb.models.enums.TipoPessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", length = 100, nullable = false)
    private TipoPessoa tipo_pessoa;

    @OneToMany
    @JoinColumn(name = "id_aluno", nullable = false, foreignKey = @ForeignKey(name = "aluno_id_aluno"))
    private String id_aluno;

    @OneToMany
    @JoinColumn(name = "id_orientador", nullable = false, foreignKey = @ForeignKey(name = "orientador_id_orientador"))
    private String id_orientador;

    @OneToMany
    @JoinColumn(name = "id_coordenador", nullable = false, foreignKey = @ForeignKey(name = "coordenador_id_coordenador"))
    private String id_coordenador;

}
