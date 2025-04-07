package com.example.gtfurb.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pessoa_relatorio")
@IdClass(PessoaRelatorioId.class)
public class PessoaRelatorio implements Serializable {

    private PessoaRelatorioId pessoaRelatorioId;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false, foreignKey = @ForeignKey(name = "pessoa_id_pessoa"))
    private Pessoa idPessoa;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_relatorio", nullable = false, foreignKey = @ForeignKey(name = "relatorio_id_relatorio"))
    private Relatorio idRelatorio;

    @NotBlank(message = "O campo de texto não pode estar vazio")
    @Size(max = 500, message = "O texto deve ter no máximo 5000 caracteres")
    @Column(name = "tx_relatorio", length = 1000, nullable = false)
    private String txtRelatorio;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = true)
    private Float tempoGasto;

}