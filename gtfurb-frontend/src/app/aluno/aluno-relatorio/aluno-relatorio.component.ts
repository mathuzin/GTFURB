import { Component, OnInit } from '@angular/core';
declare var bootstrap: any;

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

  relatorioSelecionado: any = null;

  relatorios = [
    {
      titulo: 'relatorio parcial 1',
      inicio: '01/01/2025',
      termino: '31/12/2025',
      relatorio: {
        horas: 60,
        descricao: 'Descricao do relatorio 1',
      },
      orientador: 'Parecer 1',
      coordenador: 'Avaliacao 1',
      status: 'Aprovado'
    },
    {
      titulo: 'relatorio parcial 2',
      inicio: '02/02/2025',
      termino: '31/12/2025',
      relatorio: {
        horas: 45,
        descricao: 'Descricao do relatorio 2',
      },
      orientador: 'Parecer 2',
      coordenador: 'Avaliacao 2',
      status: 'Aprovado'
    }
  ];

  novoRelatorio = {
    relatorio: {
      horas: 60,
      descricao: '',
    }
  };

  salvarRelatorio() {
    this.relatorios.push({
      titulo: 'relatorio parcial x',
      inicio: '03/03/2025',
      termino: '31/12/2025',
      ...this.novoRelatorio,
      orientador: 'Pendente',
      coordenador: 'Pendente',
      status: 'Em analise'
    });

    this.novoRelatorio = {
      relatorio: {
        horas: 0,
        descricao: ''
      }
    };

    const modalElement = document.getElementById('criarRelatorioModal');
    if (modalElement) {
      const modalInstance = bootstrap.Modal.getOrCreateInstance(modalElement);
      modalInstance.hide();

      // Corrige possíveis bugs de backdrop travado
      setTimeout(() => {
        document.querySelectorAll('.modal-backdrop').forEach(el => el.remove());
        document.body.classList.remove('modal-open');
        document.body.style.removeProperty('padding-right');
      }, 300);
    }
  }

  verRelatorio(rel: any) {
    this.relatorioSelecionado = rel;

    const modalElement = document.getElementById('verRelatorioModal');
    if (modalElement) {
      const modalInstance = bootstrap.Modal.getOrCreateInstance(modalElement);
      modalInstance.show();
    }
  }

}
