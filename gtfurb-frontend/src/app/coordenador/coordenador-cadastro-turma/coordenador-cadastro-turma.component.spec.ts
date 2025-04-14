import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CoordenadorCadastroTurmaComponent } from './coordenador-cadastro-turma.component';

describe('CoordenadorCadastroTurmaComponent', () => {
  let component: CoordenadorCadastroTurmaComponent;
  let fixture: ComponentFixture<CoordenadorCadastroTurmaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordenadorCadastroTurmaComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CoordenadorCadastroTurmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
