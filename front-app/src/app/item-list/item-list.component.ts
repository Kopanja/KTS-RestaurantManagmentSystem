import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item.model';
import { MenuService } from '../services/menu.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  public itemImage: any = null;
  public items : Item[];
  constructor(private menuService : MenuService) { }

  ngOnInit(): void {
    this.menuService.getMenu().subscribe(data => {
      this.items = data;
      console.log(this.items);
    })
  }

  private createImage(image: Blob) {
    
    if (image && image.size > 0) {
      let reader = new FileReader();

      reader.addEventListener("load", () => {
        this.itemImage = reader.result;
        
      }, false);

      reader.readAsDataURL(image);
    } else {
      console.log("greska");
    }
  }

}
