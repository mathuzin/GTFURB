package com.example.gtfurb.models.Relatorios;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.example.gtfurb.models.Usuarios.Orientador;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "relatorio_orientador")
public class RelatorioOrientador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRelatorioOrientador;

    @ManyToOne
    @JoinColumn(name = "id_orientador", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioOrientador_orientador"))
    private Orientador orientador;

    @ManyToOne
    @JoinColumn(name = "id_relatorio", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioOrientador_relatorio"))
    private Relatorio relatorio;

    @NotBlank(message = "O texto do relatório não pode estar vazio")
    @Size(max = 5000, message = "O texto do relatório deve ter no máximo 5000 caracteres")
    @Column(nullable = false, length = 5000)
    private String textoRelatorio;
}
