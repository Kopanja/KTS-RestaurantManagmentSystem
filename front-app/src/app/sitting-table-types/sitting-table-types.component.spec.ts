import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SittingTableTypesComponent } from './sitting-table-types.component';

describe('SittingTableTypesComponent', () => {
  let component: SittingTableTypesComponent;
  let fixture: ComponentFixture<SittingTableTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SittingTableTypesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SittingTableTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
