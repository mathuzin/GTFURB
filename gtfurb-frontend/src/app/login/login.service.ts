import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private BDUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  loginExiste(email: string, senha: string): Observable<any> {
    return this.http.get(`${this.BDUrl}/pessoa/login`, {
      params: {
        email: email,
        senha: senha,
      },
    });
  }

  verificaSeEhOrientador(email: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.BDUrl}/orientador-existe`, {
      params: { email: email },
    });
  }
}
