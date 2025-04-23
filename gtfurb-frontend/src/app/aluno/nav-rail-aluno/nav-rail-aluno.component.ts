import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-rail-aluno',
  templateUrl: './nav-rail-aluno.component.html',
  standalone: false,
  styleUrls: ['./nav-rail-aluno.component.scss'],
})
export class NavRailAlunoComponent implements OnInit {

  constructor() { }

  ngOnInit() { }

  navExpandida = false;
  adicionarExpandido = false;


  toggleNav() {
    this.navExpandida = !this.navExpandida;
  }
}
