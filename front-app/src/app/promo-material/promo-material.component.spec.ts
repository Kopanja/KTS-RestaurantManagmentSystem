import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PromoMaterialComponent } from './promo-material.component';

describe('PromoMaterialComponent', () => {
  let component: PromoMaterialComponent;
  let fixture: ComponentFixture<PromoMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PromoMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PromoMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
