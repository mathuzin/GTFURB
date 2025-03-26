package com.example.gtfurb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.enums.TipoPessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findByTipoPessoa(TipoPessoa tipoPessoa);
    
    List<Pessoa> findByTipoPessoaAndOrientadorIsNull(TipoPessoa tipoPessoa);
    
    List<Pessoa> findByTipoPessoaAndOrientadorId(TipoPessoa tipoPessoa, Integer orientadorId);

}
