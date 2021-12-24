import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  socket = new SockJS("http://localhost:8080/ws")
  stompClient = Stomp.over(this.socket)
  constructor() { }

  subscribe(topic : string, callback: (message : any) => any): void{
    const connected: boolean = this.stompClient.connected;
    if(connected) {
      this.subscribeToTopic(topic,callback);
      return;
    }
    this.stompClient.connect({}, ():any=>{
      this.subscribeToTopic(topic,callback);
    });
  }

  private subscribeToTopic(topic: string, callback: (message : any) => any): void {
    this.stompClient.subscribe(topic, (message : any): any => {
      //callback(JSON.parse(message.body).content);
      callback(message.body);
    })
  }
}
