import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroListar } from './libro-listar';

describe('LibroListar', () => {
  let component: LibroListar;
  let fixture: ComponentFixture<LibroListar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroListar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroListar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
