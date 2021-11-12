import { TestBed } from '@angular/core/testing';

import { SelectedTableService } from './selected-table.service';

describe('SelectedTableService', () => {
  let service: SelectedTableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelectedTableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
