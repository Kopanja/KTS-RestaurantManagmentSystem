import { Component, OnInit } from '@angular/core';
import {CompatClient, Stomp} from '@stomp/stompjs';
import { webSocket, WebSocketSubject } from "rxjs/webSocket";
import * as SockJS from 'sockjs-client';
import { Order } from '../model/order.model';
@Component({
  selector: 'app-bartender-page',
  templateUrl: './bartender-page.component.html',
  styleUrls: ['./bartender-page.component.css']
})
export class BartenderPageComponent implements OnInit {

  webSocketEndPoint: string = 'http://localhost:8080/our-websocket';
  topic: string = "/topic/bartender";
  username: string = "user1";
  stompClient: CompatClient;
  message : string;
  //subject : WebSocketSubject<Order> = webSocket("ws://localhost:8080/topic");
  constructor() { }

  ngOnInit(): void {
    this.connect();
  }

  connect() {
    
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    const _this = this;
    
    this.stompClient.connect({}, function(frame : any) {
      console.log('Connected ' + frame);
      console.log("AAAAAAAAAAAAAA" + _this.stompClient.constructor.name);
      _this.stompClient.subscribe(_this.topic, function (sdkEvent : any) {
            console.log( "aaaaaaaaaaaa " +  sdkEvent);
            _this.onMessageReceived(sdkEvent);
        });
        //_this.stompClient.reconnect_delay = 2000;
    }, this.errorCallBack);
    
};
/*
connect2(){
  this.subject.subscribe(
    msg => {console.log('message received: ' + msg); this.message = JSON.stringify(msg)}, // Called whenever there is a message from the server.
    err => console.log(err), // Called if at any point WebSocket API signals some kind of error.
    () => console.log('complete') // Called when connection is closed (for whatever reason).
  );
    
}
*/
errorCallBack(error : any) {
  console.log("errorCallBack -> " + error)
  setTimeout(() => {
      this.connect();
  }, 5000);
}

onMessageReceived(message : any) {
  console.log("Message Recieved from Server :: " + message);
  this.message = JSON.stringify(message.body);
}

}
