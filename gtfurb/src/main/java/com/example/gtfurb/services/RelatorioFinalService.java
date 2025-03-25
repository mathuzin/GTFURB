package com.example.gtfurb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.RelatorioFinal;
import com.example.gtfurb.repository.RelatorioFinalRepository;

@Service
public class RelatorioFinalService {

    @Autowired
    private RelatorioFinalRepository relatorioRepositoryFinal;

    public List<RelatorioFinal> listarTodos() {
        return relatorioRepositoryFinal.findAll();
    }

    public RelatorioFinal buscarPorId(Long id) {
        return relatorioRepositoryFinal.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado!"));
    }

    public RelatorioFinal salvar(RelatorioFinal relatorioFinal) {
        return relatorioRepositoryFinal.save(relatorioFinal);
    }

    public RelatorioFinal atualizar(Long id, RelatorioFinal novoRelatorioFinal) {
        RelatorioFinal relatorio = buscarPorId(id);
        relatorio.setTxt_relatorio(novoRelatorioFinal.getTxt_relatorio());
        relatorio.setTipo_relatorio(novoRelatorioFinal.getTipo_relatorio());
        relatorio.setRelatorio(novoRelatorioFinal.getRelatorio());
        return relatorioRepositoryFinal.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepositoryFinal.deleteById(id);
    }
}
