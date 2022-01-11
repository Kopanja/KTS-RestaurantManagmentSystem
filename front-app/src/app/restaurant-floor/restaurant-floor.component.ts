import { Component, OnInit } from '@angular/core';
import { Floor } from '../model/floor';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { TableService } from '../services/table.service';
import { WebSocketService } from '../services/web-socket.service';


@Component({
  selector: 'app-restaurant-floor',
  templateUrl: './restaurant-floor.component.html',
  styleUrls: ['./restaurant-floor.component.css']
})
export class RestaurantFloorComponent implements OnInit {
  public restaurantLayout : SittingTableClass[] = [];
  public floors : Floor[] = [];
  public selectedFloor : string;
  constructor(private tableService : TableService, private webSocketService : WebSocketService) { }

  ngOnInit(): void {
    this.tableService.getAllFloors().subscribe(data => {
      this.floors = data;
      this.selectedFloor = this.floors[0].name;
      this.tableService.getTableLayout(this.selectedFloor).subscribe(data =>{
        this.restaurantLayout = data;
      });
    })
    
    this.webSocketService.subscribe("/topic/table", (message:any): any=>{
      this.updateTables(message);
      
    })
  }

  updateTables(message:any){
    
    //console.log("PORUKA");
    let newOrder = JSON.parse(message);
    for(let table of this.restaurantLayout) {
      if(table.name === newOrder.tableName){

        table = Object.assign(table.order,newOrder);
        table.order = newOrder;
        console.log(table);
        }
    }

  }
  calcXPosition(table:SittingTableClass):number{
    let box = document.getElementById("restaurant-floor");
    if(box !== null && table.x !== undefined){
      let boundingClientRect = box.getBoundingClientRect();
      return (table.x + boundingClientRect.x)
    }
    
    return 0;
  }

  updateChild(table : SittingTableClass){
   // console.log(table);
    this.restaurantLayout.forEach(element => {
      if(element.name === table.name){
        element.order = table.order;
      }
      
    });
  }
  calcYPosition(table:SittingTableClass):number{
    let box = document.getElementById("restaurant-floor");
    if(box !== null && table.y !== undefined){
      let boundingClientRect = box.getBoundingClientRect();
      return (table.y + boundingClientRect.y)
    }
    
    return 0;
  }

  deleteFloorLayout(){
    this.tableService.deleteTableLayout().subscribe(data => {console.log(data)});
  }

  onChange(floor:any) {
    this.selectedFloor = floor;
    this.tableService.getTableLayout(this.selectedFloor).subscribe(data =>{
      this.restaurantLayout = data;
    });
}


}
