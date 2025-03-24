package com.example.gtfurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gtfurb.models.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {

}
