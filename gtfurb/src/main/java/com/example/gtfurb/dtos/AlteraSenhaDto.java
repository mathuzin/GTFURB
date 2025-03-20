package com.example.gtfurb.dtos;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlteraSenhaDto {

	@NotNull(message = "alteraSenha.id.nulo")
	private UUID id;
	
	@NotNull(message = "alteraSenha.senha.nulo")
	@NotEmpty(message = "alteraSenha.senha.vazio")
	@Size(min = 4, max = 18, message = "alteraSenha.senha.tamanho.invalido")
	private String senha;
	
}
