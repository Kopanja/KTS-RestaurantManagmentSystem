import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WebSocketService } from '../services/web-socket.service';
import { OrderedItem } from '../model/ordered-item.model';
import { Order } from '../model/order.model';
@Component({
  selector: 'app-bartender-page',
  templateUrl: './bartender-page.component.html',
  styleUrls: ['./bartender-page.component.css']
})
export class BartenderPageComponent implements OnInit {

  public orders : Order[] = [];
  constructor(private http : HttpClient, private webSocketService : WebSocketService) { }

  ngOnInit(): void {
    this.webSocketService.subscribe("/topic/bartender", (message:any): any=>{
      this.getDrinks(message);
    })
  }


  getDrinks(message : any): void {
    console.log("PORUKA")
    console.log(message)
    this.http.get<OrderedItem[]>("http://localhost:8080/api/order/" + message + "/drinks").subscribe(data =>{console.log(data); 
    let order = new Order();
    order.setItems(data); 
    this.orders.push(order);
  });
  }

  doOrdersExist():boolean {
    return this.orders.length > 0;
  }

}
