import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginUsrnPassComponent } from './login-usrn-pass.component';

describe('LoginUsrnPassComponent', () => {
  let component: LoginUsrnPassComponent;
  let fixture: ComponentFixture<LoginUsrnPassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginUsrnPassComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginUsrnPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
