import { Injectable } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import {BehaviorSubject, Observable} from "rxjs"
import { Item } from '../model/item.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../model/order.model';
@Injectable({
  providedIn: 'root'
})
export class SelectedTableService {

  selectedTable : SittingTableClass = {};
  itemsPreOrder : Item[] = [];
  private tableState$ = new BehaviorSubject<SittingTableClass>(this.selectedTable);
  private itemsPreOrderState$ = new BehaviorSubject<Item[]>(this.itemsPreOrder);
  private readonly path = "http://localhost:8080/api/table";
  constructor(private http : HttpClient) { }

  changeTableState(table : SittingTableClass) {
    this.tableState$.next(table);
    console.log(table);
  }

  changeItemsState(items : Item[]){
    this.itemsPreOrderState$.next(items);
  }

  getTable() {
    return this.tableState$.asObservable();
  }

  getItemsPreOrder(){
    return this.itemsPreOrderState$.asObservable();
  }

  addItemToOrder(item : Item){
    this.itemsPreOrderState$.getValue().push(item);
    
  }

  placeOrder(){
    let items : Item[] = this.itemsPreOrderState$.getValue();
    this.changeItemsState([]);
    let path = this.path + "/" + this.tableState$.getValue().name + "/place-order";
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<SittingTableClass>(path, JSON.stringify(items), {headers});
  }

  
}
