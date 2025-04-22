import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-rail-coordenador-orientador',
  standalone: false,
  templateUrl: './nav-rail-coordenador-orientador.component.html',
  styleUrls: ['./nav-rail-coordenador-orientador.component.scss'],
})
export class NavRailCoordenadorOrientadorComponent implements OnInit {
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

  isFilhoCoordenadorAtivo(): boolean {
    return this.router.url.includes('/coordenador/relatorios');
  }

  isFilhoOrientadorAtivo(): boolean {
    return this.router.url.includes('/coordenador/orientador/relatorios');
  }

  isFilhoCadastrarAtivo(): boolean {
    return this.router.url.startsWith('/coordenador/cadastro-');
  }
}
