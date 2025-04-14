import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CoordenadorOrientadorRelatoriosComponent } from './coordenador-orientador-relatorios.component';

describe('CoordenadorOrientadorRelatoriosComponent', () => {
  let component: CoordenadorOrientadorRelatoriosComponent;
  let fixture: ComponentFixture<CoordenadorOrientadorRelatoriosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordenadorOrientadorRelatoriosComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CoordenadorOrientadorRelatoriosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
