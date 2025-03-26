package com.example.gtfurb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepositoryFinal;

    public List<Relatorio> listarTodos() {
        return relatorioRepositoryFinal.findAll();
    }

    public Relatorio buscarPorId(Long id) {
        return relatorioRepositoryFinal.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado!"));
    }

    public Relatorio salvar(Relatorio relatorioFinal) {
        return relatorioRepositoryFinal.save(relatorioFinal);
    }

    public Relatorio atualizar(Long id, Relatorio novoRelatorioFinal) {
        Relatorio relatorio = buscarPorId(id);
        relatorio.setTxt_titulo(novoRelatorioFinal.getTxt_titulo());
        return relatorioRepositoryFinal.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepositoryFinal.deleteById(id);
    }
}
