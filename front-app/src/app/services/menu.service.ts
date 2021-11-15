import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../model/item.model';
@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private readonly path = "http://localhost:8080/api/item";
  constructor(private http : HttpClient) { }


  getMenu():Observable<Item[]>{
    return this.http.get<Item[]>(this.path);
  }
}
