import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SelectedTableService } from '../services/selected-table.service';
import { Order } from '../model/order.model';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  tableName: string|undefined;
  price : number = 0;
  order : Order|undefined;
  constructor(private selectedTableService : SelectedTableService) {
    this.selectedTableService.getTable().subscribe(data => {this.order = data.order; this.tableName = data.icon; console.log(this.order)});
   }

  ngOnInit(): void {
    
  }

  calcPrice(){
    let price = 0;
    if(this.order?.items.length !== 0){
      this.order?.items.forEach(item => {
        price += item.price;
      });
    }
    return price;
  }

}
