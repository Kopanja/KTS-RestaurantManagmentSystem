import { SittingTableClass } from './sitting-table-class.model';

describe('SittingTableClass', () => {
  it('should create an instance', () => {
    expect(new SittingTableClass(0,0,0,0,0,0,"")).toBeTruthy();
  });
});
