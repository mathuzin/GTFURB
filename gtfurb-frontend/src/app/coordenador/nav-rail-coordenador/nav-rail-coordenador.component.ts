import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-rail-coordenador',
  standalone: false,
  templateUrl: './nav-rail-coordenador.component.html',
  styleUrls: ['./nav-rail-coordenador.component.scss'],
})
export class NavRailCoordenadorComponent implements OnInit {
  constructor(public router: Router) {}

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

    if (!this.navExpandida) {
      this.adicionarExpandido = false;
    }
  }

  isFilhoCadastrarAtivo(): boolean {
    return this.router.url.startsWith('/coordenador/cadastro-');
  }
}
