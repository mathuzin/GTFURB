package com.example.gtfurb.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtfurb.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
