package com.example.gtfurb.models;

import javax.persistence.*;

import com.example.gtfurb.models.Relatorios.RelatorioAluno;
import com.example.gtfurb.models.Relatorios.RelatorioCoordenador;
import com.example.gtfurb.models.Relatorios.RelatorioOrientador;

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

    @OneToOne
    @JoinColumn(name = "id_relatorioAluno", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioFinal_relatorioAluno"))
    private RelatorioAluno relatorioAluno;

    @OneToOne
    @JoinColumn(name = "id_relatorioOrientador", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioFinal_relatorioOrientador"))
    private RelatorioOrientador relatorioOrientador;

    @OneToOne
    @JoinColumn(name = "id_relatorioCoordenador", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioFinal_relatorioCoordenador"))
    private RelatorioCoordenador relatorioCoordenador;
}
