package com.example.gtfurb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gtfurb.models.Usuarios.Aluno;
import com.example.gtfurb.repository.AlunoRepository;
import com.example.gtfurb.repository.OrientadorRepository;

import java.util.List;

@Service
public class OrienatdorService {

    private final AlunoRepository alunoRepository;

    @Autowired
    private OrientadorRepository orientadorRepository;
    @Autowired
    private BCryptPasswordEncoder bCript;

    OrienatdorService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;

    }

    public List<Aluno> buscarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(Integer idAluno, Integer idOrientador) {

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        if (aluno.getOrientador() != null && aluno.getOrientador().getId().equals(idOrientador)) {
            return aluno;
        } else {
            throw new RuntimeException("Este aluno não está vinculado a este orientador!");
        }
    }

}
