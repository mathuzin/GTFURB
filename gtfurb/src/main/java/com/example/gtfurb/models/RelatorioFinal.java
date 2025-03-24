package com.example.gtfurb.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.gtfurb.models.enums.TipoRelatorio;

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
    @Size(max = 5000, message = "O texto pode ter no máximo 5000 caracteres")
    @Column(name = "txt_relatorio", length = 1000, nullable = false)
    private String txt_relatorio;

    @OneToOne
    @JoinColumn(name = "TCC_id_tcc", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioFinal_relatorioOrientador"))
    private Integer TCC_id_tcc;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_relatorio", length = 100, nullable = true)
    private TipoRelatorio tipo_relatorio;

}
