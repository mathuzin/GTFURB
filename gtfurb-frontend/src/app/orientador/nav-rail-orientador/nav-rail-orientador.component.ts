import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-rail-orientador',
  standalone: false,
  templateUrl: './nav-rail-orientador.component.html',
  styleUrls: ['./nav-rail-orientador.component.scss'],
})
export class NavRailOrientadorComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit() {}

  navExpandida = false;

  toggleNav() {
    this.navExpandida = !this.navExpandida;
  }

  direcionarInicio(){
    this.router.navigate(['/orientador'])
  }

  direcionarRelatorio() {
    this.router.navigate(['/orientador/relatorios']);
  }

  direcionarAvisos() {
    this.router.navigate(['/orientador/avisos']);
  }
}
