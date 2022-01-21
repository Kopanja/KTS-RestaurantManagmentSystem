import { Component, OnInit } from '@angular/core';
import { ItemCategory } from '../model/item-category';
import { Item } from '../model/item.model';
import { ItemCategoryService } from '../services/item-category.service';
import { MenuService } from '../services/menu.service';
import { SelectedTableService } from '../services/selected-table.service';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public items : Item[] = [];
  public categories : ItemCategory[] = [];
  public categoryImgFolder : string;
  constructor(private menuService : MenuService, 
    private selectedTableService : SelectedTableService,
    private itemCategoryService : ItemCategoryService,
    ) { }

  ngOnInit(): void {
   
  }

  isTableSelected() :boolean{
    return this.selectedTableService.isTableSelected();
  }
  onItemClick(item : Item){
    console.log(this.isTableSelected());
    if(this.isTableSelected()){
      this.selectedTableService.addItemToOrder(item);
    }
  }
  onFoodIconClick(){
    this.itemCategoryService.getFoodCategories().subscribe(data => {
      this.categories = data;
      this.categoryImgFolder = "foodCategoriesImgs";
      console.log(this.categories);
    })
    }
    onDrinkIconClick(){
      this.itemCategoryService.getDrinkCategories().subscribe(data => {
        this.categories = data;
        this.categoryImgFolder = "drinkCategoriesImgs";
        console.log(this.categories);
      })
      }
    getCategoryIconPath(category : ItemCategory) : string {
      let imgPath = "../../assets/" + this.categoryImgFolder + "/" + category.icon;
      return imgPath;
    }

    onCategoryClick(categoryName:string){
      this.items = [];
      this.menuService.getItemsByCategoryName(categoryName).subscribe(data =>{
        this.items = data;
        console.log(this.items);
      })
    }
    onBackButtonClick(){
      this.categories = [];
      this.items = [];
    }

}
