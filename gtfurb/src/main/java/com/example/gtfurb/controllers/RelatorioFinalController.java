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

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.services.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioFinalController {

    private final RelatorioService relatorioFinalService;

    public RelatorioFinalController(RelatorioService relatorioFinalService) {
        this.relatorioFinalService = relatorioFinalService;
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarRelatorio(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.buscarPorId(id).getTxt_relatorio());
    }

    @PostMapping
    public ResponseEntity<Relatorio> salvarRelatorio(@RequestBody Relatorio relatorioFinal) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.salvar(relatorioFinal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable Long id, @RequestBody Relatorio novosDados) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioFinalService.atualizar(id, novosDados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Long id) {
        relatorioFinalService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
