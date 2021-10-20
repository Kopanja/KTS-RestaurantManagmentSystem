import { SittingTableTypeClass } from './sitting-table-type-class.model';

describe('SittingTableTypeClass', () => {
  it('should create an instance', () => {
    expect(new SittingTableTypeClass(0,0,"","")).toBeTruthy();
  });
});
