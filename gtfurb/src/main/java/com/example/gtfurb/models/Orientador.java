package com.example.gtfurb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orientador")
public class Orientador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome não pode estar vazio")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres")
    @Column(name = "nm_orientador", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "O email pode ter no máximo 100 caracteres")
    @Column(name = "email_orientador", length = 100, nullable = false)
    private String email;
}
