import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { OrientadorRelatorioComponent } from './orientador-relatorio.component';

describe('OrientadorRelatorioComponent', () => {
  let component: OrientadorRelatorioComponent;
  let fixture: ComponentFixture<OrientadorRelatorioComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ OrientadorRelatorioComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(OrientadorRelatorioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
