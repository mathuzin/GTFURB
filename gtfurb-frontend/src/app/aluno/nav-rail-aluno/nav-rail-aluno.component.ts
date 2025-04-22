import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-rail-aluno',
  templateUrl: './nav-rail-aluno.component.html',
  standalone: false,
  styleUrls: ['./nav-rail-aluno.component.scss'],
})
export class NavRailAlunoComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

  navExpandida = false;
  coordenadorExpandido = false;
  coordenadorOrientadorExpandido = false;
  adicionarExpandido = false;


  toggleNav() {
    this.navExpandida = !this.navExpandida;

    if (!this.navExpandida) {
      this.coordenadorExpandido = false;
    }

    if (!this.navExpandida) {
      this.coordenadorOrientadorExpandido = false;
    }

    if (!this.navExpandida){
      this.adicionarExpandido = false;
    }
  }

}
