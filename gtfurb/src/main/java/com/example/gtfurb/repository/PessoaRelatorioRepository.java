package com.example.gtfurb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.PessoaRelatorio;

@Repository
public interface PessoaRelatorioRepository extends JpaRepository<PessoaRelatorio, Long> {

    List<PessoaRelatorio> listarTodos();

    PessoaRelatorio buscarPorId(Long id);

    PessoaRelatorio salvar(PessoaRelatorio pessoaRelatorio);

    PessoaRelatorio atualizar(Long id, String novoTxt);

    void deletar(Long id);
}
