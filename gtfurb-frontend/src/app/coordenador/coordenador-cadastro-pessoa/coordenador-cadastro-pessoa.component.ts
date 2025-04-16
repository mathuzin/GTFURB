import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-coordenador-cadastro-pessoa',
  standalone: false,
  templateUrl: './coordenador-cadastro-pessoa.component.html',
  styleUrls: ['./coordenador-cadastro-pessoa.component.scss'],
})
export class CoordenadorCadastroPessoaComponent implements OnInit {
  constructor() {}

  form!: FormGroup;

  telaCadastro = false;
  telaFiltro = false;

  cargoSelecionado: string = '';
  coordenadorAcumula: string = '';

  cursoSelecionado: string = '';

  ngOnInit() {
    this.form = new FormGroup({
      nome: new FormControl(''),
      email: new FormControl(''),
    });
  }

  cadastrarPessoaAbrir() {
    this.telaCadastro = true;
  }

  cadastrarPessoaFechar() {
    this.telaCadastro = false;
  }

  buscarPorFiltroAbrir() {
    this.telaFiltro = true;
  }

  buscarPorFiltroFechar() {
    this.telaFiltro = false;
  }

  selecionarCargo(cargo: string) {
    if (cargo === 'Coordenador') {
      if (this.cargoSelecionado === 'Coordenador') {
        this.coordenadorAcumula =
          this.coordenadorAcumula === 'Orientador' ? '' : 'Orientador';
      } else {
        this.cargoSelecionado = 'Coordenador';
        this.coordenadorAcumula = '';
      }
    } else {
      this.cargoSelecionado = cargo;
      this.coordenadorAcumula = '';
    }
  }

  selecionarCurso(curso: string) {
    this.cursoSelecionado = curso;
  }

  relatorios = [
    {
      nome: 'Fulano',
      email: 'fulano@furb.br',
      cargo: 'Aluno',
      curso: 'BCC',
      turma: '01/2025',
      orientador: 'Professor Exemplo',
      status: 'Ativo',
    },
    {
      nome: 'Beltrano',
      email: 'beltrano@furb.br',
      cargo: 'Orientador',
      curso: '',
      turma: '',
      orientador: '',
      status: 'Ativo',
    },
  ];
}
