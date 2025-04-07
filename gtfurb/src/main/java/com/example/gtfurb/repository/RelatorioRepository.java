package com.example.gtfurb.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {

    List<Relatorio> findAll();

    @Query("SELECT r FROM Relatorio r WHERE r.idRelatorioFinal = :id")
    Optional<Relatorio> findRelatorioById(Integer id);

    @Modifying
    @Query("UPDATE Relatorio r SET r.txt_titulo = :novoTitulo, r.dataInicio = :novoDataInicio, r.dataTermino = :novoDataTermino WHERE r.idRelatorioFinal = :id")
    int updateRelatorio(Integer id, String novoTitulo, LocalDate novoDataInicio, LocalDate novoDataTermino);

    @Transactional
    @Modifying
    @Query("DELETE FROM Relatorio r WHERE r.idRelatorioFinal = :id")
    void deleteById(Integer id);
}
