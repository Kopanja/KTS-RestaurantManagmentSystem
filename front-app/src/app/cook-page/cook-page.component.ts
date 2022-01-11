import { Component, OnInit } from '@angular/core';
import { OrderedItem } from '../model/ordered-item.model';
import { Order } from '../model/order.model';
import { HttpClient } from '@angular/common/http';
import { WebSocketService } from '../services/web-socket.service';

@Component({
  selector: 'app-cook-page',
  templateUrl: './cook-page.component.html',
  styleUrls: ['./cook-page.component.css']
})
export class CookPageComponent implements OnInit {

  public orders : Order[] = [];
  constructor(private http : HttpClient, private webSocketService : WebSocketService) { }

  ngOnInit(): void {
    this.getOrders();
    this.webSocketService.subscribe("/topic/cook", (message:any): any=>{
      let exist = false;
      let counter = 0;
      for(let order of this.orders) {
        if(order !== undefined){
          if(order.orderId == message){
            exist = true;
            break;
          }
        }
        
        counter = counter + 1
     }
      this.getFoods(message, exist, counter);
    })
  }

  getOrders() : void {
    this.http.get<Order[]>("http://localhost:8080/api/cook").subscribe(data =>
    {
      console.log(data);
      this.orders = data;
    }); 

  }
  getFoods(message : any, exist:boolean, counter : number): void {
    this.http.get<Order>("http://localhost:8080/api/order/" + message + "/foods").subscribe(data =>{console.log(data);
    if(exist){
      this.orders[counter] = data;
    }else{
      let order = data;
      this.orders.push(order);
    } 
    
  });
  }

  doOrdersExist():boolean {
    return this.orders.length > 0;
  }

  orderComplete(order : Order){

    let index = this.orders.indexOf(order);
    delete this.orders[index];
  }

}