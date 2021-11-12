import { Component, OnInit } from '@angular/core';
import { SittingTableClass } from '../model/sitting-table-class.model';
import { SelectedTableService } from '../services/selected-table.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  table : SittingTableClass;
  
  constructor(private selectedTableService : SelectedTableService) {
    this.selectedTableService.getTable().subscribe(data => {this.table = data; console.log(this.table)});
   }

  ngOnInit(): void {
    
  }

}
