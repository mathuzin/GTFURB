package com.example.gtfurb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.PessoaRelatorioId;

@Repository
public interface PessoaRelatorioRepository extends JpaRepository<PessoaRelatorio, PessoaRelatorioId> {

    List<PessoaRelatorio> listarTodos();

    PessoaRelatorio buscarPorId(PessoaRelatorioId id);

    PessoaRelatorio salvar(PessoaRelatorio pessoaRelatorio);

    PessoaRelatorio atualizar(PessoaRelatorioId id, String novoTxt);

    void deletar(PessoaRelatorioId id);
}
