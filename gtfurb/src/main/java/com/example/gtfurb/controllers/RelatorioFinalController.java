package com.example.gtfurb.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gtfurb.services.RelatorioFinalService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioFinalController {

    private final RelatorioFinalService relatorioFinalService;

    // Injeção de dependência pelo construtor
    public RelatorioFinalController(RelatorioFinalService relatorioFinalService) {
        this.relatorioFinalService = relatorioFinalService;
    }

    @GetMapping("/{id}")
    public String buscarRelatorio(@PathVariable String id) {
        buscarRelatorio(id);
        return "Buscando relatório com ID: " + id;
    }

    @PostMapping
    public String salvarRelatorio(@RequestBody String dados) {
        salvarRelatorio(dados);
        return "Relatório salvo com sucesso: " + dados;
    }

    @PutMapping("/{id}")
    public String atualizarRelatorio(@PathVariable String id, @RequestBody String novosDados) {
        atualizarRelatorio(id, novosDados);
        return "Relatório " + id + " atualizado para: " + novosDados;
    }

    @DeleteMapping("/{id}")
    public String excluirRelatorio(@PathVariable String id) {
        excluirRelatorio(id);
        return "Relatório " + id + " excluído.";
    }
}
