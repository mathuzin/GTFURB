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
      descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi venenatis commodo ultrices. Morbi pretium arcu risus, sed eleifend mi ultricies vitae. Duis elementum eleifend ipsum, non finibus diam aliquam eu. Vestibulum congue libero sed mi rhoncus tempus. Maecenas in mi lorem. Integer laoreet diam rutrum lorem accumsan, ac maximus orci laoreet. Curabitur nulla justo, sagittis a sapien sed, auctor efficitur erat. Cras quam quam, ultrices vel erat sed, vehicula condimentum dolor. Ut volutpat lacus turpis, vitae posuere mi ornare eu. Proin pulvinar venenatis tellus non accumsan. Proin eu orci sollicitudin, interdum dui eget, posuere odio. Curabitur at risus lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; ',
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
