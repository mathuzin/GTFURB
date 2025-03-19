package br.furb.inf.furbot.repositories.gestao;

import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.repositories.Repository;

public interface TurmaCustomRepository extends Repository<Turma> {
	
	Integer obterProximoId();
}
