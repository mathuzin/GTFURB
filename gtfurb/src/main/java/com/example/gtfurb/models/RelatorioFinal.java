package com.example.gtfurb.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "relatorio_final")
public class RelatorioFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRelatorioFinal;

    @NotBlank(message = "O texto não pode estar vazio")
    @Size(max = 1000, message = "O texto pode ter no máximo 1000 caracteres")
    @Column(name = "txt_relatorio", length = 1000, nullable = false)
    private String txt_relatorio;

    @OneToOne
    @JoinColumn(name = "pessoa_id_pessoa", nullable = false, foreignKey = @ForeignKey(name = "pessoa_id_pessoa"))
    private Integer id_pessoa;


    @OneToOne
    @JoinColumn(name = "relatorio", nullable = true, foreignKey = @ForeignKey(name = "fk_relatorioFinal_relatorio"))
    private RelatorioFinal relatorioFinal;

}
