package com.example.gtfurb.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtfurb.models.Usuarios.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByOrientadorIsNull();

    List<Aluno> findByOrientadorId(Integer idOrientador);

}
