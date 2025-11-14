import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamoEditar } from './prestamo-editar';

describe('PrestamoEditar', () => {
  let component: PrestamoEditar;
  let fixture: ComponentFixture<PrestamoEditar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrestamoEditar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrestamoEditar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
