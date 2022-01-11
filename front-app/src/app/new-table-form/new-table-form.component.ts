import { Component, OnInit,  Output,EventEmitter, } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SittingTableTypeClass } from '../model/sitting-table-type-class.model';
import { TableTypeService } from '../services/table-type.service';


@Component({
  selector: 'app-new-table-form',
  templateUrl: './new-table-form.component.html',
  styleUrls: ['./new-table-form.component.css']
})
export class NewTableFormComponent implements OnInit {
  @Output()
  newTableEvent = new EventEmitter<SittingTableClass>();
  public sittingTableTypeList : SittingTableTypeClass[] = [];
  public selectedTableType : SittingTableTypeClass;
  public newTable : SittingTableClass = new SittingTableClass(undefined,undefined,undefined,undefined,undefined, undefined, undefined, "");
  constructor(private tableTypeService : TableTypeService) { }
  
  ngOnInit(): void {
    this.tableTypeService.getTableTypes().subscribe(data =>{
      this.sittingTableTypeList = data; 
      this.selectedTableType = this.sittingTableTypeList[0];
     
    });
  }

  onChange(tableType:any) {
   this.selectedTableType = tableType;
}

onSubmit(): void {
  this.newTable.icon = this.selectedTableType.icon;
  this.newTable.numOfSeats = this.selectedTableType.numOfSeats;
  this.newTable.typeId = this.selectedTableType.id;
 
  console.log(this.newTable);
  this.newTableEvent.emit(this.newTable);
  this.newTable = new SittingTableClass(undefined,undefined,undefined,undefined,undefined, undefined, undefined, "");
}

}
