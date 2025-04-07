package com.example.gtfurb.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetricasDto {
	private UUID turmaId;
	private UUID saveId;
	private UUID jogadorId;
	private UUID partidaId;
	private String usuario;
	private String codigo;
	private int errosCompilacao;
	private int errosExecucao;
	private int execucoes;
	private int linhas;
	private int tempo;
	private int regiaoId;
	private int faseId;
}
