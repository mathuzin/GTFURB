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
        return relatorioRepository.save(pessoaRelatorio);
    }

    public PessoaRelatorio atualizar(Long id, String novoTxt) {
        PessoaRelatorio relatorio = buscarPorId(id);
        relatorio.setTxtRelatorio((novoTxt));
        return relatorioRepository.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepository.deleteById(id);
    }
    
}
