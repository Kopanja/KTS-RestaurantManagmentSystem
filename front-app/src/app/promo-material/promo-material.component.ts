import { Component, OnInit } from '@angular/core';
import { MenuService } from '../services/menu.service';

@Component({
  selector: 'app-promo-material',
  templateUrl: './promo-material.component.html',
  styleUrls: ['./promo-material.component.css']
})
export class PromoMaterialComponent implements OnInit {

  public menuLinks : Map<string,string>;
  public fileNames : string[];
  public returnMessage : string;
  public areMenuesRefreshed : boolean;
  constructor(private menuService : MenuService) {
    this.menuLinks =  new Map<string, string>();
    this.fileNames = [];
    this.returnMessage = "";
    this.areMenuesRefreshed = false;
   }

  ngOnInit(): void {
    this.getLinks();
  }

  getLinks(){
    this.menuLinks = new Map<string, string>();
    this.fileNames = [];
    this.menuService.getMenuLinks().subscribe(data => {
      //console.log(data);
      data.forEach(element => {
        console.log(element);
        let splitLink : string[] = element.split("/");
        let fileName :string = splitLink[splitLink.length-1];
        this.menuLinks.set(fileName,element);
        this.fileNames.push(fileName);
      });
    })

  }
  goToLink(fileName:string){
    let url = this.menuLinks.get(fileName);
    window.open(url, "_blank");
  }

  refreshFoodMenu(){

    this.areMenuesRefreshed = false;
    this.returnMessage = "";
    this.menuService.refreshFoodMenu().subscribe(data =>{
      this.returnMessage = data;
      this.areMenuesRefreshed = true;
      this.getLinks();
    });
  }
  refreshDrinkMenu(){
    this.areMenuesRefreshed = false;
    this.returnMessage = "";
    this.menuService.refreshDrinkMenu().subscribe(response=>{
      console.log(response);
      this.returnMessage = response;
      this.areMenuesRefreshed = true;
      this.getLinks();
    })

  }



}
