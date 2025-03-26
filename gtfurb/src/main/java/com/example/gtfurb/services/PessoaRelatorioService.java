package com.example.gtfurb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.repository.PessoaRelatorioRepository;

@Service
public class PessoaRelatorioService {

    @Autowired
    private PessoaRelatorioRepository relatorioRepository;

    public List<PessoaRelatorio> listarTodos() {
        return relatorioRepository.findAll();
    }

    public PessoaRelatorio buscarPorId(Long id) {
        return relatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));
    }

    public PessoaRelatorio salvar(PessoaRelatorio pessoaRelatorio) {
        if (pessoaRelatorio.getTxtRelatorio() == null || pessoaRelatorio.getTxtRelatorio().isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }

        return relatorioRepository.save(pessoaRelatorio);
    }

    public PessoaRelatorio atualizar(Long id, String novoTxt, float tmp_tempoRelatorio ) {
        if (novoTxt == null || novoTxt.isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }   

        if (tmp_tempoRelatorio == 0) {
            throw new IllegalArgumentException("Tempo gasto do relatório é obrigatório.");
        }

        PessoaRelatorio relatorio = buscarPorId(id);

        relatorio.setTxtRelatorio((novoTxt));
        relatorio.setTempoGasto(tmp_tempoRelatorio);

        return relatorioRepository.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepository.deleteById(id);
    }
    
}
