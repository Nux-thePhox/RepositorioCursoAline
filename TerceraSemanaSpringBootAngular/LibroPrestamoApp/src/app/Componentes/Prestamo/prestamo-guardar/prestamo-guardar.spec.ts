import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamoGuardar } from './prestamo-guardar';

describe('PrestamoGuardar', () => {
  let component: PrestamoGuardar;
  let fixture: ComponentFixture<PrestamoGuardar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrestamoGuardar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrestamoGuardar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
