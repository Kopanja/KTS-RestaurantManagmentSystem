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

  public sittingTableList : SittingTableClass[] = [];
  public sittingTableTypeList : SittingTableTypeClass[] = [];
  constructor(private tableService : TableService) { }

  ngOnInit(): void {
    this.sittingTableTypeList = [new SittingTableTypeClass(1,2,"2Seat", "2seat.jpg"), new SittingTableTypeClass(2,4,"4Seat", "4seat.jpg"), new SittingTableTypeClass(3,6, "6seat", "6seat.jpg")]
    //this.sittingTableList = [new SittingTableClass(1,50,134, 2), new SittingTableClass(1,180,225, 3), new SittingTableClass(1,117,-137, 4)]
  }

  onItemDrop($event : CdkDragEnd, table : SittingTableClass){ 
    let element = $event.source.getRootElement();
    let boundingClientRect = element.getBoundingClientRect();
    let parentPosition = this.getParentPosition(element);
    
    let xOffset = boundingClientRect.x - parentPosition.x;
    let yOffset = boundingClientRect.y - parentPosition.y;

    table.setX(xOffset);
    table.setY(yOffset)
    console.log(table);   
  }


  onClick(tableType : SittingTableTypeClass) {
    this.sittingTableList.push(new SittingTableClass(undefined,tableType.getId(),0,0,0,tableType.getNumOfSeats(), tableType.getIcon()))
  }

 

  save(){
    console.log(this.sittingTableList)
    this.tableService.submitTableLayout(this.sittingTableList).subscribe();
  }

  getParentPosition(el:any){
    let parent = el.parentElement;
    let boundingClientRect = parent.getBoundingClientRect();
    return {x : boundingClientRect.left, y : boundingClientRect.top}

  }

}
