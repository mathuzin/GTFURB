package com.example.gtfurb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    List<Relatorio> listarTodos();

    Relatorio buscarPorId(Long id);

    Relatorio salvar(Relatorio relatorioFinal);

    Relatorio atualizar(Long id, String novoTitulo, LocalDate novoDataInicio, LocalDate novoDataTermino);

    void deletar(Long id);

}
