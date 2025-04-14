import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-rail-coordenador-orientador',
  standalone: false,
  templateUrl: './nav-rail-coordenador-orientador.component.html',
  styleUrls: ['./nav-rail-coordenador-orientador.component.scss'],
})
export class NavRailCoordenadorOrientadorComponent implements OnInit {
  constructor() {}

  ngOnInit() {}

  navExpandida = false;
  coordenadorExpandido = false;
  coordenadorOrientadorExpandido = false;

  toggleNav() {
    this.navExpandida = !this.navExpandida;

    if (!this.navExpandida) {
      this.coordenadorExpandido = false;
    }

    if (this.navExpandida) {
      this.coordenadorOrientadorExpandido = false;
    }
  }
}
