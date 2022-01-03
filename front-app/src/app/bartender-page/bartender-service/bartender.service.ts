import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { WebSocketService } from 'src/app/services/web-socket.service'; 
@Injectable({
  providedIn: 'root'
})
export class BartenderService {

  constructor(private http : HttpClient, private webSocketService : WebSocketService) { }
}
