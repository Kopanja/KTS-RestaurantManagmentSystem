import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemCategory } from '../model/item-category';

import { ItemCategoryService } from '../services/item-category.service';
import { MenuService } from '../services/menu.service';

@Component({
  selector: 'app-item-page',
  templateUrl: './item-page.component.html',
  styleUrls: ['./item-page.component.css']
})
export class ItemPageComponent implements OnInit {

  public foodCategories : ItemCategory[];
  public drinkCategories : ItemCategory[];
  public foodItems : Item[];
  public drinkItems : Item[];
  constructor(private itemCategoryService : ItemCategoryService, private menuService : MenuService) { }

  ngOnInit(): void {
    this.itemCategoryService.getFoodCategories().subscribe(data =>{
      this.foodCategories = data;
    });
    this.itemCategoryService.getDrinkCategories().subscribe(data => {
      this.drinkCategories = data;
    })
  }

  getFoodItems(name : string){
    this.menuService.getItemsByCategoryName(name).subscribe(data =>
      this.foodItems = data
      )
  }

  getDrinkItems(name : string){
    this.menuService.getItemsByCategoryName(name).subscribe(data =>{
      this.drinkItems = data;
    })
  }

}
