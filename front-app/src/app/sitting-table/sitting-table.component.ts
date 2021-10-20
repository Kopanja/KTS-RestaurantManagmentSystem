import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { TableService } from '../services/table.service';
@Component({
  selector: 'app-sitting-table',
  templateUrl: './sitting-table.component.html',
  styleUrls: ['./sitting-table.component.css']
})
export class SittingTableComponent implements OnInit {
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
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return (table.x + boundingClientRect.x)
    }
    
    return 0;
  }

  calcYPosition(table:SittingTableClass):number{
    let box = document.getElementById("restaurant-floor");
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return (table.y + boundingClientRect.y)
    }
    
    return 0;
  }

  tableClick(table:SittingTableClass){
    console.log(table);
  }

}
