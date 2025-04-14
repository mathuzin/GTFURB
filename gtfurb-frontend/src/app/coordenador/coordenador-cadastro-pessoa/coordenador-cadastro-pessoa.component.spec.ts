import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CoordenadorCadastroPessoaComponent } from './coordenador-cadastro-pessoa.component';

describe('CoordenadorCadastroPessoaComponent', () => {
  let component: CoordenadorCadastroPessoaComponent;
  let fixture: ComponentFixture<CoordenadorCadastroPessoaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordenadorCadastroPessoaComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CoordenadorCadastroPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
