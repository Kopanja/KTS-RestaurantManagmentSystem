import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../model/item';
import { MenuService } from '../services/menu.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  @Input() items : Item[];
  
  constructor(private menuService : MenuService, private router:Router) { }

  ngOnInit(): void {
    
    //this.menuService.getItemImage("Classic Burger").subscribe(data =>{
     // this.createImage(data);
    //});
  }
 

  detailsClick(item:Item){
    this.router.navigate(['/item-details/',item.name]);
  }

}
