import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroEditar } from './libro-editar';

describe('LibroEditar', () => {
  let component: LibroEditar;
  let fixture: ComponentFixture<LibroEditar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroEditar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroEditar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
