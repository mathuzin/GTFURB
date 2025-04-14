import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-aluno-relatorio',
  templateUrl: './aluno-relatorio.component.html',
  standalone: false,
  styleUrls: ['./aluno-relatorio.component.scss'],
})
export class AlunoRelatorioComponent implements OnInit {


  ngOnInit(): void {

  }
  constructor() { }

  relatorios = [
    {
      titulo: 'exemplo titulo 1',
      inicio: '01/01/2025',
      termino: '31/12/2025',
      aluno: 'Relatorio 1',
      orientador: 'Parecer 1',
      coordenador: 'Avaliacao 1',
      status: 'Aprovado'
    },
    {
      titulo: 'exemplo titulo 2',
      inicio: '02/02/2025',
      termino: '31/12/2025',
      aluno: 'Relatorio 2',
      orientador: 'Parecer 2',
      coordenador: 'Avaliacao 2',
      status: 'Aprovado'
    }
  ];
}

