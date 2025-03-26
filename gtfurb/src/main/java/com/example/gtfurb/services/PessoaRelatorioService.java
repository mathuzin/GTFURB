package com.example.gtfurb.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Pessoa;
import com.example.gtfurb.models.PessoaRelatorio;
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

    public PessoaRelatorio buscarPorId(Long id) {
        return relatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));
    }

    public PessoaRelatorio salvar(PessoaRelatorio pessoaRelatorio) {
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


        return relatorioRepository.save(pessoaRelatorio);
    }

    public PessoaRelatorio atualizar(Long id, String novoTxt, float tmp_tempoRelatorio ) {
        if (novoTxt == null || novoTxt.isEmpty()) {
            throw new IllegalArgumentException("Texto do relatório é obrigatório.");
        }   

        if (tmp_tempoRelatorio == 0) {
            throw new IllegalArgumentException("Tempo gasto do relatório é obrigatório.");
        }

        PessoaRelatorio relatorio = buscarPorId(id);

        relatorio.setTxtRelatorio((novoTxt));
        relatorio.setTempoGasto(tmp_tempoRelatorio);

        return relatorioRepository.save(relatorio);
    }

    public void deletar(Long id) {
        relatorioRepository.deleteById(id);
    }
    
}
