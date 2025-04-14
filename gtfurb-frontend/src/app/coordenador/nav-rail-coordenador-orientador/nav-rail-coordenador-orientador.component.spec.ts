import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { NavRailCoordenadorOrientadorComponent } from './nav-rail-coordenador-orientador.component';

describe('NavRailCoordenadorOrientadorComponent', () => {
  let component: NavRailCoordenadorOrientadorComponent;
  let fixture: ComponentFixture<NavRailCoordenadorOrientadorComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ NavRailCoordenadorOrientadorComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(NavRailCoordenadorOrientadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
