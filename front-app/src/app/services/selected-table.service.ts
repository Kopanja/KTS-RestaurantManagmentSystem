import { Injectable } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import {BehaviorSubject, Observable} from "rxjs"
import { Item } from '../model/item.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../model/order.model';
import { TableAndItemsPreOrder } from '../model/table-and-items-pre-order.model';
@Injectable({
  providedIn: 'root'
})
export class SelectedTableService {

  selectedTable : SittingTableClass = {};
  itemsPreOrder : Item[] = [];
  tableAndPreOrderItems : TableAndItemsPreOrder = {table : this.selectedTable, items : this.itemsPreOrder};
  private tableAndPreOrderItems$ = new BehaviorSubject<TableAndItemsPreOrder>(this.tableAndPreOrderItems);
  private readonly path = "http://localhost:8080/api/table";
  constructor(private http : HttpClient) { }

  changeTableState(table : SittingTableClass) {
    this.tableAndPreOrderItems$.getValue().table = table;
    this.changeTableAndPreOrderItems(this.tableAndPreOrderItems$.getValue());
  }

  changeTableAndPreOrderItems(table : TableAndItemsPreOrder){
    this.tableAndPreOrderItems$.next(table);
  }

  getTableAndPreOrderItems(){
    return this.tableAndPreOrderItems$.asObservable();
  }
  changeItemsState(items : Item[]){
    this.tableAndPreOrderItems$.getValue().items = items;
    this.changeTableAndPreOrderItems(this.tableAndPreOrderItems$.getValue());
  }

  getTableState(){
    return this.tableAndPreOrderItems$.getValue().table;
  }

  addItemToOrder(item : Item){
    this.tableAndPreOrderItems$.getValue().items.push(item);
    
  }

  removeItemFromOrder(item : Item){
    const index = this.tableAndPreOrderItems$.getValue().items.indexOf(item);
    if (index > -1) {
      this.tableAndPreOrderItems$.getValue().items.splice(index, 1);
    }
  }
  placeOrder(){ 
    let items : Item[] = this.tableAndPreOrderItems$.getValue().items;
    let path = this.path + "/" + this.tableAndPreOrderItems$.getValue().table.name + "/place-order";
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.tableAndPreOrderItems$.getValue().items = [];
    this.changeTableAndPreOrderItems(this.tableAndPreOrderItems$.getValue());
    if(this.tableAndPreOrderItems$.getValue().table.order){
      console.log("Order Exists");
      console.log(items);
      //PUT
      return this.http.put<SittingTableClass>(path, JSON.stringify(items), {headers});
    }else{   
      return this.http.post<SittingTableClass>(path, JSON.stringify(items), {headers});
    }
    
  }

  billOrder(){
    let items : Item[] = this.tableAndPreOrderItems$.getValue().items;
    let path = this.path + "/" + this.tableAndPreOrderItems$.getValue().table.name + "/bill-order";
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<SittingTableClass>(path, JSON.stringify(items), {headers});
  }

  
}
