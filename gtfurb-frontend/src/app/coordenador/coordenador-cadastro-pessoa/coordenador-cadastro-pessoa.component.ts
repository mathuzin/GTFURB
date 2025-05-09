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

  mostrarCargoOpcoesFiltro = false;
  mostrarCursoOpcoesFiltro = false;
  mostrarModalFiltro = true;

  isSelected = false;

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
    this.cargoSelecionado = '';
    this.coordenadorAcumula = '';
    this.cursoSelecionado = '';
    this.form.reset();
  }

  buscarPorFiltroAbrir() {
    this.telaFiltro = true;
  }

  buscarPorFiltroFechar() {
    this.telaFiltro = false;
  }

  selecionarCargo(cargo: string) {
    if (cargo === 'Orientador') {
      if (this.cargoSelecionado === 'Coordenador') {
        if (this.coordenadorAcumula === 'Orientador') {
          this.cargoSelecionado = 'Orientador';
          this.coordenadorAcumula = '';
        } else {
          this.coordenadorAcumula = 'Orientador';
        }
      } else {
        this.cargoSelecionado = 'Orientador';
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

  selecionarCargoFiltro() {
    this.mostrarCargoOpcoesFiltro = !this.mostrarCargoOpcoesFiltro;
    this.mostrarCursoOpcoesFiltro = false;
  }

  selecionarCursoFiltro() {
    this.isSelected = !this.isSelected;
    this.mostrarCursoOpcoesFiltro = !this.mostrarCursoOpcoesFiltro;
    this.mostrarCargoOpcoesFiltro = false;
  }

  selecionarOpcaoFinalFiltro() {
    this.mostrarModalFiltro = false;
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
