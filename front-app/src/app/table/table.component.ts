import { Component, OnInit, Input, Output,EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { Item } from '../model/item';
import { Order } from '../model/order.model';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { TableAndItemsPreOrder } from '../model/table-and-items-pre-order.model';
import { SelectedTableService } from '../services/selected-table.service';
import { WebSocketService } from '../services/web-socket.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit, OnChanges{

  @Input() table : SittingTableClass;
  @Output()
  someEvent = new EventEmitter<SittingTableClass>();
  public tableStyles : string[] = [];
  public itemsPreOrder : Item[] = [];
  public tableAndItemsPreOrder : TableAndItemsPreOrder;
  public isOrder : boolean = false;
  public isSelected : boolean = false;

  
  constructor(private selectedTableService : SelectedTableService, private webSocketService : WebSocketService, private http : HttpClient) {
    
   }
  ngOnChanges(changes: SimpleChanges): void {
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
     // console.log(this.table);
      this.someEvent.emit(this.table);
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


  tableClick(){
    this.selectedTableService.changeTableAndPreOrderItems(this.tableAndItemsPreOrder);
    
  }

  //Treba da se napravi po kategorijama kada budu implementirane
  countPreparedDrinks(){
    let count = 0;
    this.table.order?.items.forEach(element => {
      if(element.prepared){
        count = count + 1;
      }
    });
    return count;
  }

  countPreparedFoods(){
    let count = 0;
    this.table.order?.items.forEach(element => {
      if(element.prepared){
        count = count + 1;
      }
    });
    return count;
  }

  calcXDrink(){
      if(this.table.icon === "tableMedium.png"){
        return -25;
      }
      return -10;
      //return (boundingClientRect.x)
    }

    calcXFood(){
      if(this.table.icon === "tableMedium.png"){
        return 90;
      }
      return 70;
      //return (boundingClientRect.x)
    }
    
  

  calcYDrink(){
    return 0;
  }
  calcYFood(){
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
