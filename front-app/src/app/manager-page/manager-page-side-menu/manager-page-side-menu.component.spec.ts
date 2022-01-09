import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerPageSideMenuComponent } from './manager-page-side-menu.component';

describe('ManagerPageSideMenuComponent', () => {
  let component: ManagerPageSideMenuComponent;
  let fixture: ComponentFixture<ManagerPageSideMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerPageSideMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerPageSideMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
