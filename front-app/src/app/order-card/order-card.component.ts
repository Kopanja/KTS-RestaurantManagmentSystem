import { Component, OnInit, Input } from '@angular/core';
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
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }

  checkBoxClicked(item : OrderedItem){
    console.log(this.order);
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.put<boolean>("http://localhost:8080/api/order/ordered-item-made/" + item.id,JSON.stringify(this.order), {headers}).subscribe();
    //console.log(itemId);
  }

}
