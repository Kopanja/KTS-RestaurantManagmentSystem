import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SelectedTableService } from '../services/selected-table.service';
import { Order } from '../model/order.model';
import { Item } from '../model/item.model';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  tableName: string|undefined;
  price : number = 0;
  order : Order|undefined;
  itemsPreOrder : Item[];
  constructor(private selectedTableService : SelectedTableService) {
    this.selectedTableService.getTableAndPreOrderItems().subscribe(data => {this.order = data.table.order; this.tableName = data.table.name; this.itemsPreOrder = data.items});
    //this.selectedTableService.getItemsPreOrder().subscribe(data => {this.itemsPreOrder = data});
   }

  ngOnInit(): void {
    
  }

  calcPrice(){
    let price = 0;
    if(this.order?.items !== undefined){
      this.order?.items.forEach(item => {
        price += item.item.price;
      });
    }if(this.itemsPreOrder.length !== 0){
      this.itemsPreOrder.forEach(item=> {
        price += item.price;
      });
    }
    return price;
  }

  placeOrderClicked(){
   this.selectedTableService.placeOrder().subscribe(data => {this.selectedTableService.changeTableState(data)});
    //this.selectedTableService.placeOrder();
  }

  deleteClick(item : Item){
    this.selectedTableService.removeItemFromOrder(item);
  }
}
