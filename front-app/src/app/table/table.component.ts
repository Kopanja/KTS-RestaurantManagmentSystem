import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../model/order.model';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SelectedTableService } from '../services/selected-table.service';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input() table : SittingTableClass;
  public tableStyles : string[];
  public l = ["a", "b", "c"]
  public tableSize : number;

  constructor(private selectedTableService : SelectedTableService) {
    
    this.tableStyles = ["free"];
    
   }

  ngOnInit(): void {
    this.getTableSize();
    this.table.order = new Order();
    console.log(this.table);
  }

  tableClick(){
    //this.tableStyles.push("occupied");
    this.tableStyles.push("table-selected");
    this.selectedTableService.changeState(this.table);
    let box = document.getElementById("table" + this.table.tableId);
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      console.log(boundingClientRect.x)
    }
    
  }

  calcXDrink(){
    let box = document.getElementById("table" + this.table.tableId);
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return 0;
      //return (boundingClientRect.x)
    }
    
    return 0;
  }

  calcYDrink(){
    let box = document.getElementById("table" + this.table.tableId);
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return 0;
      //return (boundingClientRect.y)
    }
    
    return 0;
  }

  getStyleObject(){
    this.selectedTableService.getTable().subscribe(data => {
      if(data.tableId === this.table.tableId){
        this.tableStyles.push("table-selected")
      }else{
        if(this.tableStyles.includes("table-selected")){
          this.removeStyleClass("table-selected");
        }
      }
    });
    return this.tableStyles;
  }

  getTableSize(): void {
    if(this.table.icon === "tableSmall.png"){
      this.tableStyles.push("table-small");
    }else if(this.table.icon === "tableMedium.png"){
      this.tableStyles.push("table-medium");
    }else{
      this.tableStyles.push("table-large");
    }

  }

  removeStyleClass(value : string){
    const index = this.tableStyles.indexOf(value);
    if (index > -1) {
      this.tableStyles.splice(index, 1);
}
  }

  doesOrderExist():boolean{
    if(this.table.order?.items.length === 0){
      return false;
    }
    return true;
  }

}
