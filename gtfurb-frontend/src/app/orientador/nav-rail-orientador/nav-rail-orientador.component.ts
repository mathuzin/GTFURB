import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-rail-orientador',
  standalone: false,
  templateUrl: './nav-rail-orientador.component.html',
  styleUrls: ['./nav-rail-orientador.component.scss'],
})
export class NavRailOrientadorComponent implements OnInit {
  constructor() {}

  ngOnInit() {}

  navExpandida = false;

  toggleNav() {
    this.navExpandida = !this.navExpandida;
  }
}
