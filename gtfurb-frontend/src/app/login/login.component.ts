import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  standalone: false,
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  senhaVisivel = false;

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$/i),
        ],
      ],
      senha: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const email = this.loginForm.value.email;
      const senha = this.loginForm.value.senha;

      this.loginService.loginExiste(email, senha).subscribe({
        next: (usuario) => {
          console.log('Usuário encontrado:', usuario);

          if (usuario.tipoPessoa === 'COORDENADOR') {
            this.router.navigate(['/home-coordenador']);
          } else if (usuario.tipoPessoa === 'ORIENTADOR') {
            this.router.navigate(['/home-orientador']);
          } else {
            this.router.navigate(['/home-aluno']);
          }
        },
        error: (err) => {
          console.error('Erro na requisição:', err);
          alert('Email ou senha inválidos');
        },
      });
    } else {
      this.loginForm.markAllAsTouched();
      console.log('Formulário inválido');
    }
  }

  toggleSenha() {
    this.senhaVisivel = !this.senhaVisivel;
  }
}
