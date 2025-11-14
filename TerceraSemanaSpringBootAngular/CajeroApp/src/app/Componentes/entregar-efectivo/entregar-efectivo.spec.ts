import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntregarEfectivo } from './entregar-efectivo';

describe('EntregarEfectivo', () => {
  let component: EntregarEfectivo;
  let fixture: ComponentFixture<EntregarEfectivo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EntregarEfectivo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntregarEfectivo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
