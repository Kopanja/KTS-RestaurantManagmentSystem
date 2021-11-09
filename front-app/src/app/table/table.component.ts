import { Component, OnInit, Input } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';


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

  constructor() {
    
    this.tableStyles = ["free"];
    
   }

  ngOnInit(): void {
    this.getTableSize();
    console.log(this.table);
  }

  tableClick(){
    //this.tableStyle = "occupied";
    this.tableStyles.push("occupied");
    this.tableStyles.push("table-selected");
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

}
