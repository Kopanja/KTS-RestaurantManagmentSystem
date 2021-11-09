import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { Router } from '@angular/router';
@Component({
  selector: 'app-sitting-table-types',
  templateUrl: './sitting-table-types.component.html',
  styleUrls: ['./sitting-table-types.component.css']
})
export class SittingTableTypesComponent implements OnInit {

  
  constructor(private router : Router) { }

  ngOnInit(): void {
    
  }

  changeToCreatorTool(){
    this.router.navigate(['/create-layout']);
  }

  changeToFloorLayout(){
    this.router.navigate(['/floor-layout']);
  }

}
