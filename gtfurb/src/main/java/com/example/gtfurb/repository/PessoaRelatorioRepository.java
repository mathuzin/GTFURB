package com.example.gtfurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.PessoaRelatorioId;

@Repository
public interface PessoaRelatorioRepository extends JpaRepository<PessoaRelatorio, PessoaRelatorioId> {

    @Modifying
    @Transactional
    @Query("UPDATE PessoaRelatorio pr SET pr.txtRelatorio = :novoTxt, pr.tempoGasto = :tmpTempoRelatorio WHERE pr.pessoaRelatorioId = :id")
    int atualizarPessoaRelatorio(PessoaRelatorioId id, String novoTxt, float tmpTempoRelatorio);
}