import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPorMarca } from './listar-por-marca';

describe('ListarPorMarca', () => {
  let component: ListarPorMarca;
  let fixture: ComponentFixture<ListarPorMarca>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarPorMarca]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPorMarca);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
