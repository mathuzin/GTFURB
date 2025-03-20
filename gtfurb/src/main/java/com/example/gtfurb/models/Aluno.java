package com.example.gtfurb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
<<<<<<< HEAD
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
=======
import javax.persistence.Entity;
>>>>>>> 3e3f76f (Versao do pom alterada e metodos de criptografia adicionados)
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAluno;

    @NotBlank(message = "O nome não pode estar vazio")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres")
    @Column(name = "nm_aluno", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "O email pode ter no máximo 100 caracteres")
    @Column(name = "email_aluno", length = 100, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_orientador", nullable = false, foreignKey = @ForeignKey(name = "fk_aluno_orientador"))
    private Orientador orientador;

}
