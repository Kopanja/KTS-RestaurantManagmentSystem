import { Injectable } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import {BehaviorSubject} from "rxjs"
import { Item } from '../model/item.model';
import { Order } from '../model/order.model';
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

  addItemToOrder(item : Item){
    if(this.state$.getValue().order){
      this.state$.getValue().order?.items.push(item);
    
    }else{
      this.state$.getValue().order = new Order();
      this.state$.getValue().order?.items.push(item);
    }
    
  }

  
}
