package com.example.gtfurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.PessoaRelatorio;

@Repository
public interface PessoaRelatorioRepository extends JpaRepository<PessoaRelatorio, Long> {

}
