package com.example.gtfurb.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
import com.example.gtfurb.models.Relatorio;
import com.example.gtfurb.models.enums.TipoPessoa;
import com.example.gtfurb.repository.PessoaRelatorioRepository;
import com.example.gtfurb.repository.PessoaRepository;
import com.example.gtfurb.repository.RelatorioRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private PessoaRelatorioRepository pessoaRelatorioRepository;

    public List<Pessoa> buscarCoordenadores() {
        return pessoaRepository.findByTipoPessoa(TipoPessoa.COORDENADOR);
    }

    public List<Pessoa> buscarOrientadores() {
        return pessoaRepository.findByTipoPessoa(TipoPessoa.ORIENTADOR);
    }

    public Pessoa buscarOrientadorPeloId(Integer idOrientador) {
        Pessoa orientador = pessoaRepository.findById(idOrientador)
                .orElseThrow(() -> new EntityNotFoundException("Orientador não encontrado."));

        if (orientador.getTipoPessoa() != TipoPessoa.ORIENTADOR) {
            throw new RuntimeException("A pessoa encontrada não é um orientador.");
        }
        return orientador;
    }

    public Pessoa buscarCoordenadorPeloId(Integer idCoordenador) {
        Pessoa coordenador = pessoaRepository.findById(idCoordenador)
                .orElseThrow(() -> new EntityNotFoundException("Coordenador não encontrado."));

        if (coordenador.getTipoPessoa() != TipoPessoa.COORDENADOR) {
            throw new RuntimeException("A pessoa encontrada não é um coordenador.");
        }
        return coordenador;
    }

    public List<Pessoa> buscarAlunosSemOrientador() {
        return pessoaRepository.findByTipoPessoaAndOrientadorIsNull(TipoPessoa.ALUNO);
    }

    public List<Pessoa> buscarAlunosPorOrientador(Integer idOrientador) {
        return pessoaRepository.findByTipoPessoaAndOrientadorId(TipoPessoa.ALUNO, idOrientador);
    }

    public Pessoa criarAluno(Pessoa aluno) {

        if (aluno.getNome() == null || aluno.getNome().isEmpty() || aluno.getEmail() == null
                || aluno.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        if (aluno.getTipoPessoa() == TipoPessoa.ALUNO && aluno.getOrientador() == null) {
            throw new IllegalArgumentException("Orientador é obrigatório para alunos.");
        }

        return pessoaRepository.save(aluno);
    }

    public Pessoa criarOrientador(Pessoa orientador) {

        if (orientador.getNome() == null || orientador.getNome().isEmpty() || orientador.getEmail() == null
                || orientador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        return pessoaRepository.save(orientador);
    }

    public Pessoa criarCoordenador(Pessoa coordenador) {

        if (coordenador.getNome() == null || coordenador.getNome().isEmpty() || coordenador.getEmail() == null
                || coordenador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e e-mail são obrigatórios.");
        }

        return pessoaRepository.save(coordenador);
    }

    public Relatorio criarRelatorio(Relatorio relatorio) {

        if (relatorio.getTxt_titulo() == null || relatorio.getTxt_titulo().isEmpty()) {
            throw new IllegalArgumentException("Título é obrigatório.");
        }

        return relatorioRepository.save(relatorio);
    }

    public PessoaRelatorio criarPessoaRelatorio(PessoaRelatorio pessoaRelatorio) {

        if (pessoaRelatorio.getTxtRelatorio() == null || pessoaRelatorio.getTxtRelatorio().isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }

        Pessoa pessoa = pessoaRepository.findById(pessoaRelatorio.getIdPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));

        if (pessoa.getTipoPessoa() == TipoPessoa.ALUNO) {
            // Verificando se tempoGasto é null ou menor ou igual a 0
            if (pessoaRelatorio.getTempoGasto() == null || pessoaRelatorio.getTempoGasto() <= 0) {
                throw new IllegalArgumentException("O tempo gasto é obrigatório para alunos e deve ser maior que 0.");
            }
        } else {
            // Para pessoas que não são alunos, setamos o tempoGasto para 0
            pessoaRelatorio.setTempoGasto(0f);
        }

        return pessoaRelatorioRepository.save(pessoaRelatorio);
    }

}
