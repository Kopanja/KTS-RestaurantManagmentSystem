import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SittingTableTypeClass } from '../model/sitting-table-type-class.model';
import { CdkDragEnd} from '@angular/cdk/drag-drop';
import { TableService } from '../services/table.service';
import { TableTypeService } from '../services/table-type.service';


@Component({
  selector: 'app-creator-tool',
  templateUrl: './creator-tool.component.html',
  styleUrls: ['./creator-tool.component.css']
})
export class CreatorToolComponent implements OnInit {
  public sittingTableList : SittingTableClass[] = [];
  public sittingTableTypeList : SittingTableTypeClass[] = [];
  constructor(private tableService : TableService, private tableTypeService : TableTypeService) { }

  ngOnInit(): void {
    this.tableTypeService.getTableTypes().subscribe(data =>{
      this.sittingTableTypeList = data; 
      console.log(this.sittingTableTypeList);
     
    })
  }

  onItemDrop($event : CdkDragEnd, table : SittingTableClass){ 
    let element = $event.source.getRootElement();
    let boundingClientRect = element.getBoundingClientRect();
    let parentPosition = this.getParentPosition(element);
    
    let xOffset = boundingClientRect.x - parentPosition.x;
    let yOffset = boundingClientRect.y - parentPosition.y;

    table.x = xOffset;
    table.y = yOffset;
    console.log(table);
  }


  newTableAdded(table : SittingTableClass) {

    this.sittingTableList.push(table);
  }

 doesTableExist():boolean{
   if(this.sittingTableList.length > 0){
     return true;
   }
   return false;
 }

  save(){
    console.log(this.sittingTableList)
    this.tableService.createNewFloor(this.sittingTableList, "Floor3").subscribe();
  }

  getParentPosition(el:any){
    let parent = el.parentElement;
    let boundingClientRect = parent.getBoundingClientRect();
    return {x : boundingClientRect.left, y : boundingClientRect.top}

  }

}