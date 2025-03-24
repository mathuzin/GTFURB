package com.example.gtfurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.RelatorioFinal;

@Repository
public interface RelatorioFinalRepository extends JpaRepository<RelatorioFinal, Long> {
}
