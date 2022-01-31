import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../model/item';
import { MenuService } from '../services/menu.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  @Input() items : Item[];
  public itemImage: any;
  constructor(private menuService : MenuService) { }

  ngOnInit(): void {
    
    //this.menuService.getItemImage("Classic Burger").subscribe(data =>{
     // this.createImage(data);
    //});
  }

  getImage(itemName : string){
    this.menuService.getItemImage(itemName).subscribe(data =>{
      return this.createImage(data);
    })
  }

  private createImage(image: Blob) {
    
    if (image && image.size > 0) {
      let reader = new FileReader();

      reader.addEventListener("load", () => {
        return reader.result;
        
      }, false);

      reader.readAsDataURL(image);
    } else {
      console.log("greska");
    }
  }

  isAdmin():boolean{
    return true;
  }

  editClick(item:Item){

  }
  deleteClick(item:Item){

  }

}
