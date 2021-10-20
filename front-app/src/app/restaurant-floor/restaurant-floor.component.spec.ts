import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantFloorComponent } from './restaurant-floor.component';

describe('RestaurantFloorComponent', () => {
  let component: RestaurantFloorComponent;
  let fixture: ComponentFixture<RestaurantFloorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantFloorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantFloorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
