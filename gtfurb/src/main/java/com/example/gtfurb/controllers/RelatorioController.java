package com.example.gtfurb.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.services.RelatorioService;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Relatorio>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarRelatorio(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.buscarPorId(id).getTxt_titulo());
    }

    // POST
    @PostMapping
    public ResponseEntity<Relatorio> salvarRelatorio(@RequestBody Relatorio relatorioFinal) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.salvar(relatorioFinal));
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable Integer id,
            @RequestBody Relatorio dadosAtualizados) {
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.atualizar(id,
                dadosAtualizados.getTxt_titulo(),
                dadosAtualizados.getDataInicio(),
                dadosAtualizados.getDataTermino()));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRelatorio(@PathVariable Integer id) {
        relatorioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
