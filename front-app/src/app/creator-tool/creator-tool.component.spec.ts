import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatorToolComponent } from './creator-tool.component';

describe('CreatorToolComponent', () => {
  let component: CreatorToolComponent;
  let fixture: ComponentFixture<CreatorToolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatorToolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatorToolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
