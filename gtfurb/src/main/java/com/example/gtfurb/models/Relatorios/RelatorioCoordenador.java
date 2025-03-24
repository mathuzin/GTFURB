package com.example.gtfurb.models.Relatorios;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.example.gtfurb.models.Usuarios.Coordenador;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "relatorio_coordenador")
public class RelatorioCoordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRelatorioCoordenador;

    @ManyToOne
    @JoinColumn(name = "id_coordenador", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioCoordenador_coordenador"))
    private Coordenador coordenador;

    @ManyToOne
    @JoinColumn(name = "id_relatorio", nullable = false, foreignKey = @ForeignKey(name = "fk_relatorioCoordenador_relatorio"))
    private Relatorio relatorio;

    @NotBlank(message = "O texto do relatório não pode estar vazio")
    @Size(max = 5000, message = "O texto do relatório deve ter no máximo 5000 caracteres")
    @Column(nullable = false, length = 5000)
    private String textoRelatorio;
}
