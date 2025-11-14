import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamoListar } from './prestamo-listar';

describe('PrestamoListar', () => {
  let component: PrestamoListar;
  let fixture: ComponentFixture<PrestamoListar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrestamoListar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrestamoListar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
