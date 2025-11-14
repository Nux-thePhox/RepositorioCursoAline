import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetiroEfectivo } from './retiro-efectivo';

describe('RetiroEfectivo', () => {
  let component: RetiroEfectivo;
  let fixture: ComponentFixture<RetiroEfectivo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RetiroEfectivo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RetiroEfectivo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
