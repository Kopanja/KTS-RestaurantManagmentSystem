import { Injectable } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import {BehaviorSubject} from "rxjs"
@Injectable({
  providedIn: 'root'
})
export class SelectedTableService {

  selectedTable : SittingTableClass = {};
  private state$ = new BehaviorSubject<SittingTableClass>(this.selectedTable);
  constructor() { }

  changeState(table : SittingTableClass) {
    this.state$.next(table);
  }
  setTable(table : SittingTableClass){
    this.selectedTable = table;
  }

  getTable() {
    return this.state$.asObservable();
  }
}
