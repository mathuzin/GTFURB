import { Component } from '@angular/core';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-coordenador',
  templateUrl: './coordenador.component.html',
  standalone: false,
  styleUrl: './coordenador.component.scss',
})
export class CoordenadorComponent {
  ehOrientador: boolean = false;

  constructor(private loginService: LoginService) {}

  ngOnInit() {
    const email = localStorage.getItem('email');

    if (email) {
      this.loginService.verificaSeEhOrientador(email).subscribe({
        next: (res) => {
          this.ehOrientador = res;
        },
        error: (err) => {
          console.error('Erro ao verificar se é orientador:', err);
          this.ehOrientador = false;
        },
      });
    }
  }
}
