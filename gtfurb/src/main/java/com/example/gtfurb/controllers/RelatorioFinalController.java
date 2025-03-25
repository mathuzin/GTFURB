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
    }
}
