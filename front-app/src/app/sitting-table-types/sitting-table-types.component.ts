import { Component, OnInit } from '@angular/core';
import { SittingTableTypeClass } from '../model/sitting-table-type-class.model';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { Router } from '@angular/router';
import { TableTypeService } from '../services/table-type.service';
@Component({
  selector: 'app-sitting-table-types',
  templateUrl: './sitting-table-types.component.html',
  styleUrls: ['./sitting-table-types.component.css']
})
export class SittingTableTypesComponent implements OnInit {

  public sittingTableTypeList : SittingTableTypeClass[];
  constructor(private router : Router, private tableTypeService : TableTypeService) { }

  ngOnInit(): void {
    
  }

  changeToCreatorTool(){
    this.router.navigate(['/create-layout']);
  }

  changeToFloorLayout(){
    this.router.navigate(['/floor-layout']);
  }

}
