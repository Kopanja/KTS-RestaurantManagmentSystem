import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SittingTableComponent } from './sitting-table.component';

describe('SittingTableComponent', () => {
  let component: SittingTableComponent;
  let fixture: ComponentFixture<SittingTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SittingTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SittingTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
