import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Order } from '../model/order.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { OrderedItem } from '../model/ordered-item.model';

@Component({
  selector: 'app-order-card',
  templateUrl: './order-card.component.html',
  styleUrls: ['./order-card.component.css']
})
export class OrderCardComponent implements OnInit {

  @Input() order : Order;
  @Output()
  orderCompleteEvent = new EventEmitter<Order>();
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }

  checkBoxClicked(item : OrderedItem){
    console.log(this.order);
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.put<boolean>("http://localhost:8080/api/order/ordered-item-made/" + item.id,JSON.stringify(this.order), {headers}).subscribe(
      data => {
        this.order.items.forEach(orderedItem => {
          if(orderedItem.id === item.id){
            orderedItem.prepared = data;
          }
        });
      }
    );
    //console.log(itemId);
  }

  isOrderComplete():boolean{
    let isComplete = true;
    this.order.items.forEach(item => {
      if(!item.prepared){
        isComplete = false;
      }
    });
    return isComplete;
  }

  closeClick(){
    this.orderCompleteEvent.emit(this.order);
  }

}
