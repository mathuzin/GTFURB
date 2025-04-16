import { Component, OnInit } from '@angular/core';
declare var bootstrap: any;

@Component({
  selector: 'app-aluno-avisos',
  templateUrl: './aluno-avisos.component.html',
  standalone: false,
  styleUrls: ['./aluno-avisos.component.scss'],
})
export class AlunoAvisosComponent implements OnInit {

  constructor() { }

  ngOnInit() { }

  avisoSelecionado: any = null;

  avisos = [
    {
      assunto: 'aviso 1',
      descricao: 'descricao descricao',
      data: '31/12/2025',
    },
    {
      assunto: 'aviso 2',
      descricao: 'descricao descricao descricao',
      data: '31/12/2025',
    }
  ];

  abrirAviso(aviso: any) {
    this.avisoSelecionado = aviso;

    const modalElement = document.getElementById('verAvisoModal');
    if (modalElement) {
      const modalInstance = bootstrap.Modal.getOrCreateInstance(modalElement);
      modalInstance.show();
    }
  }
}
