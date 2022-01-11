import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTableFormComponent } from './new-table-form.component';

describe('NewTableFormComponent', () => {
  let component: NewTableFormComponent;
  let fixture: ComponentFixture<NewTableFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewTableFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTableFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
