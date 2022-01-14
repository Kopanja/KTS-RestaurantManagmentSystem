import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item.model';
import { MenuService } from '../services/menu.service';
import { SelectedTableService } from '../services/selected-table.service';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public items : Item[];
  constructor(private menuService : MenuService, private selectedTableService : SelectedTableService) { }

  ngOnInit(): void {
    this.menuService.getMenu().subscribe(data =>{
      this.items = data; 
    })
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

}
