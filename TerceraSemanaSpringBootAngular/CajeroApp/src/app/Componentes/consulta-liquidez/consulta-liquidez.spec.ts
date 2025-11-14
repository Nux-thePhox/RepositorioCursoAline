import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaLiquidez } from './consulta-liquidez';

describe('ConsultaLiquidez', () => {
  let component: ConsultaLiquidez;
  let fixture: ComponentFixture<ConsultaLiquidez>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultaLiquidez]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultaLiquidez);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
