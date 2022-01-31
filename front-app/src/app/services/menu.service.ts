import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../model/item';
@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private readonly path = "http://localhost:8080/api/item";
  constructor(private http : HttpClient) { }


  getMenu():Observable<Item[]>{
    return this.http.get<Item[]>(this.path);
  }

  getItemsByCategoryName(categoryName : string):Observable<Item[]>{
    return this.http.get<Item[]>(this.path + "/category/" + categoryName);
  }

  getItemByName(itemName : string):Observable<Item>{
    return this.http.get<Item>(this.path + "/" + itemName);
  }

  getMenuLinks():Observable<string[]>{
    return this.http.get<string[]>(this.path + "/menu-links");
  }

  refreshFoodMenu(){
    return this.http.get(this.path + "/update-food-menu", {responseType: 'text'});
  }


  refreshDrinkMenu(){
    return this.http.get(this.path + "/update-drink-menu", {responseType: 'text'});
  }

  getItemImage(itemName : string):Observable<Blob>{
    return this.http.get(`${this.path}/${itemName}/image`, {
      responseType: 'blob'
    });

    //return this.http.get(this.path + "/" + itemName + "/image");
  }
}
