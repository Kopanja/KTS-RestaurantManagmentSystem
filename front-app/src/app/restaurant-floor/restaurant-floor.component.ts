import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SittingTableTypeClass } from '../model/sitting-table-type-class.model';
import { CdkDragEnd} from '@angular/cdk/drag-drop';
import { TableService } from '../services/table.service';

@Component({
  selector: 'app-restaurant-floor',
  templateUrl: './restaurant-floor.component.html',
  styleUrls: ['./restaurant-floor.component.css']
})
export class RestaurantFloorComponent implements OnInit {
  public restaurantLayout : SittingTableClass[] = [];

  constructor(private tableService : TableService) { }

  ngOnInit(): void {
    this.tableService.getTableLayout().subscribe(data =>{
      this.restaurantLayout = data; 
      console.log(this.restaurantLayout);
     
    })
  }

  calcXPosition(table:SittingTableClass):number{
    let box = document.getElementById("restaurant-floor");
    if(box !== null && table.x !== undefined){
      let boundingClientRect = box.getBoundingClientRect();
      return (table.x + boundingClientRect.x)
    }
    
    return 0;
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


}
