package com.example.gtfurb.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.PessoaRelatorioId;
import com.example.gtfurb.models.enums.TipoPessoa;
import com.example.gtfurb.repository.PessoaRelatorioRepository;
import com.example.gtfurb.repository.PessoaRepository;

@Service
public class PessoaRelatorioService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaRelatorioRepository relatorioRepository;

    public List<PessoaRelatorio> listarTodos() {
        return relatorioRepository.findAll();
    }

    public PessoaRelatorio buscarPorId(PessoaRelatorioId id) {
        return relatorioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Relatório não encontrado"));
    }

    public PessoaRelatorio salvar(PessoaRelatorio pessoaRelatorio) {
        if (pessoaRelatorio.getTxtRelatorio() == null || pessoaRelatorio.getTxtRelatorio().isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }

        Integer idPessoa = pessoaRelatorio.getPessoaRelatorioId().getIdPessoa();
        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        if (pessoa.getTipoPessoa() == TipoPessoa.ALUNO) {
            if (pessoaRelatorio.getTempoGasto() == null || pessoaRelatorio.getTempoGasto() <= 0) {
                throw new IllegalArgumentException("O tempo gasto é obrigatório para alunos e deve ser maior que 0.");
            }
        } else {
            pessoaRelatorio.setTempoGasto(0f);
        }

        return relatorioRepository.save(pessoaRelatorio);
    }

    public PessoaRelatorio atualizar(PessoaRelatorioId id, String novoTxt, float tmp_tempoRelatorio) {
        if (novoTxt == null || novoTxt.isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }

        Pessoa pessoa = pessoaRepository.findById(id.getIdPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        if (pessoa.getTipoPessoa() == TipoPessoa.ALUNO) {
            if (tmp_tempoRelatorio <= 0) {
                throw new IllegalArgumentException("Tempo gasto deve ser maior que 0 para alunos.");
            }
        } else {
            tmp_tempoRelatorio = 0f;
        }

        int linhasAfetadas = relatorioRepository.atualizarPessoaRelatorio(id, novoTxt, tmp_tempoRelatorio);
        if (linhasAfetadas == 0) {
            throw new EntityNotFoundException("Relatório não encontrado para atualização.");
        }

        return buscarPorId(id);
    }

    public void deletar(PessoaRelatorioId id) {
        relatorioRepository.deleteById(id);
    }
}