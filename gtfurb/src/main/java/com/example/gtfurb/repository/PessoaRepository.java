package com.example.gtfurb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.enums.TipoPessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT p FROM Pessoa p WHERE p.tipoPessoa = :tipoPessoa")
    List<Pessoa> findByTipoPessoa(TipoPessoa tipoPessoa);

    @Query("SELECT p FROM Pessoa p WHERE p.tipoPessoa = :tipoPessoa AND p.orientador IS NULL")
    List<Pessoa> findByTipoPessoaAndOrientadorIsNull(TipoPessoa tipoPessoa);

    @Query("SELECT p FROM Pessoa p WHERE p.tipoPessoa = :tipoPessoa AND p.orientador.id = :orientadorId")
    List<Pessoa> findByTipoPessoaAndOrientadorId(TipoPessoa tipoPessoa, Integer orientadorId);

    @Query("SELECT p FROM Pessoa p WHERE p.id = :id AND p.tipoPessoa = 'ORIENTADOR'")
    Optional<Pessoa> findOrientadorById(Integer id);

    @Query("SELECT p FROM Pessoa p WHERE p.id = :id AND p.tipoPessoa = 'COORDENADOR'")
    Optional<Pessoa> findCoordenadorById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Pessoa p SET p.nome = :nome, p.email = :email, p.orientador = :orientador WHERE p.id = :id")
    void updatePessoa(Integer id, String nome, String email, Pessoa orientador);

    @Transactional
    @Modifying
    @Query("DELETE FROM Pessoa p WHERE p.id = :id")
    void deleteById(Integer id);
}
