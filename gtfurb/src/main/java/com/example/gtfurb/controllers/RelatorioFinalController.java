package com.example.gtfurb.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gtfurb.dtos.RelatorioDTO;
import com.example.gtfurb.models.RelatorioFinal;
import com.example.gtfurb.services.RelatorioFinalService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioFinalController {

    private final RelatorioFinalService relatorioFinalService;

    public RelatorioFinalController(RelatorioFinalService relatorioFinalService) {
        this.relatorioFinalService = relatorioFinalService;
    }

    @GetMapping
    public ResponseEntity<List<RelatorioFinal>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.listarTodos());
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<String> buscarRelatorio(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.buscarPorId(id).getTxt_relatorio());
    }

    @PostMapping
    public ResponseEntity<RelatorioFinal> salvarRelatorio(@RequestBody RelatorioFinal relatorioFinal) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.salvar(relatorioFinal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatorioFinal> atualizarRelatorio(@PathVariable Long id, @RequestBody RelatorioFinal novosDados) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.atualizar(id, novosDados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Long id) {
        relatorioFinalService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
=======
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
>>>>>>> 9bc3c0676da613006590b4e0e6d637ce054ef3a6
    }
}
