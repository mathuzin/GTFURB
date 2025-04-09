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
      email: ['', [Validators.required, Validators.email]],
      senha: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const email = this.loginForm.value.email;
      const senha = this.loginForm.value.senha;

      this.loginService.loginExiste(email, senha).subscribe({
        next: (res) => {
          if (res && res.length > 0) {
            const usuario = res[0];
            console.log('Usuário encontrado:', usuario);

            if (usuario.tipo_pessoa === 'coordenador') {
              this.router.navigate(['/home-coordenador']);
            } else if (usuario.tipo_pessoa === 'orientador') {
              this.router.navigate(['/home-orientador']);
            } else {
              this.router.navigate(['/home-aluno']);
            }
          } else {
            alert('Email ou senha inválidos');
          }
        },
        error: (err) => {
          console.error('Erro na requisição:', err);
          alert(
            'Erro ao tentar logar. Verifique sua conexão ou tente novamente.'
          );
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
