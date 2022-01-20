import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItemCategory } from '../model/item-category';
@Injectable({
  providedIn: 'root'
})
export class ItemCategoryService {
  private readonly path = "http://localhost:8080/api/item-category";

  constructor(private http : HttpClient) { }


  getFoodCategories():Observable<ItemCategory[]>{
    return this.http.get<ItemCategory[]>(this.path + "/food-categories");
  }

  getDrinkCategories():Observable<ItemCategory[]>{
    return this.http.get<ItemCategory[]>(this.path + "/drink-categories");
  }
}
