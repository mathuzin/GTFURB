package com.example.gtfurb.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class RelatorioService {

    @Autowired
    private final RelatorioRepository relatorioRepositoryFinal;

    public RelatorioService(RelatorioRepository relatorioRepositoryFinal) {
        this.relatorioRepositoryFinal = relatorioRepositoryFinal;
    }

    public List<Relatorio> listarTodos() {
        return relatorioRepositoryFinal.findAll();
    }

    public Relatorio buscarPorId(Integer id) {
        return relatorioRepositoryFinal.findRelatorioById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado!"));
    }

    public Relatorio salvar(Relatorio relatorioFinal) {
        if (relatorioFinal.getTxt_titulo() == null || relatorioFinal.getTxt_titulo().isEmpty()) {
            throw new IllegalArgumentException("Título do relatório é obrigatório.");
        }

        return relatorioRepositoryFinal.save(relatorioFinal);
    }

    public Relatorio atualizar(Integer id, String novoTitulo, LocalDate novaDataInicio, LocalDate novaDataTermino) {
        if (novoTitulo == null || novoTitulo.isEmpty()) {
            throw new IllegalArgumentException("Título do relatório é obrigatório.");
        }

        int updated = relatorioRepositoryFinal.updateRelatorio(id, novoTitulo, novaDataInicio, novaDataTermino);

        if (updated == 0) {
            throw new RuntimeException("Erro ao atualizar relatório ou relatório não encontrado.");
        }

        return buscarPorId(id);
    }

    public void deletar(Integer id) {
        relatorioRepositoryFinal.deleteById(id);
    }
}