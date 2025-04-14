import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { NavRailCoordenadorComponent } from './nav-rail-coordenador.component';

describe('NavRailCoordenadorComponent', () => {
  let component: NavRailCoordenadorComponent;
  let fixture: ComponentFixture<NavRailCoordenadorComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ NavRailCoordenadorComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(NavRailCoordenadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
