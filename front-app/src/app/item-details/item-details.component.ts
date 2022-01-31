import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from '../model/item';
import { MenuService } from '../services/menu.service';
@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  public item : Item;
  public itemImage: any;
  constructor(private route: ActivatedRoute, private menuService : MenuService) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      let name = params.name;
      this.menuService.getItemByName(name).subscribe(data =>{
        this.item = data;
        this.menuService.getItemImage(name).subscribe(data =>{
          this.createImage(data);
        })
      });
    });
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
