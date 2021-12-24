import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../model/item.model';
import { Order } from '../model/order.model';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { TableAndItemsPreOrder } from '../model/table-and-items-pre-order.model';
import { SelectedTableService } from '../services/selected-table.service';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input() table : SittingTableClass;
  public tableStyles : string[] = [];
  public itemsPreOrder : Item[] = [];
  public tableAndItemsPreOrder : TableAndItemsPreOrder;
  public isOrder : boolean = false;
  public isSelected : boolean = false;

  
  constructor(private selectedTableService : SelectedTableService) {
    
   }

  ngOnInit(): void {
    this.getTableSize();
    this.tableAndItemsPreOrder = {table : this.table, items : this.itemsPreOrder};
    this.selectedTableService.getTableAndPreOrderItems().subscribe(data => {this.tableStyle(data.table)});
    if(this.table.order){
      this.isOrder = true;
    }
    //this.getStyleObject();
    
  }


  tableStyle(data : SittingTableClass){

    if(data.tableId === this.tableAndItemsPreOrder.table.tableId){
      this.table = data;
      if(this.tableAndItemsPreOrder.table.order !== null){
        
        this.isOrder = true;
      }else{
        this.isOrder = false;
      }
      this.isSelected = true;
    }else{
      this.isSelected = false;
    }
    
  }

  updateItemsPreOrder(data : Item[]){

  }
  tableClick(){
    //this.tableStyles.push("occupied");
    //this.selectedTableService.changeTableState(this.table);
    //this.selectedTableService.changeItemsState(this.itemsPreOrder);
    this.selectedTableService.changeTableAndPreOrderItems(this.tableAndItemsPreOrder);
  }


  calcXDrink(){
    let box = document.getElementById("table" + this.tableAndItemsPreOrder.table.tableId);
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return 0;
      //return (boundingClientRect.x)
    }
    
    return 0;
  }

  calcYDrink(){
    let box = document.getElementById("table" + this.tableAndItemsPreOrder.table.tableId);
    if(box !== null){
      let boundingClientRect = box.getBoundingClientRect();
      return 0;
      //return (boundingClientRect.y)
    }
    
    return 0;
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
