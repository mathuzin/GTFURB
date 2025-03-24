package com.example.gtfurb.models.Usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coordenador", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email_coordenador")
})
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres")
    @Column(name = "nm_coordenador", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "O email pode ter no máximo 100 caracteres")
    @Column(name = "email_coordenador", length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha não pode estar vazia")
    @Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres.")
    @Column(name = "senha_coordenador", length = 255, nullable = false)
    private String senha;
}
