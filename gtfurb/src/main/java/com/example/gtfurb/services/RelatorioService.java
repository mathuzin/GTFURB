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
        if (relatorioFinal.getTxt_titulo() == null || relatorioFinal.getTxt_titulo().isEmpty()) {
            throw new IllegalArgumentException("Título do relatório é obrigatório.");
        }

        return relatorioRepositoryFinal.save(relatorioFinal);
    }

    public Relatorio atualizar(Long id, String novoTitulo) {

        if (novoTitulo == null || novoTitulo.isEmpty()) {
            throw new IllegalArgumentException("Título do relatório é obrigatório.");
        }

        Relatorio relatorio = buscarPorId(id);

        relatorio.setTxt_titulo(novoTitulo);

        return relatorioRepositoryFinal.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepositoryFinal.deleteById(id);
    }
}
