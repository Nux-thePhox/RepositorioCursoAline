import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroGuardar } from './libro-guardar';

describe('LibroGuardar', () => {
  let component: LibroGuardar;
  let fixture: ComponentFixture<LibroGuardar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroGuardar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroGuardar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
