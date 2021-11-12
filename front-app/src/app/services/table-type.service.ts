import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SittingTableTypeClass } from '../model/sitting-table-type-class.model';

@Injectable({
  providedIn: 'root'
})
export class TableTypeService {

  private readonly path = "http://localhost:8080/api/table-type";
  constructor(private http : HttpClient) { }

  getTableTypes():Observable<SittingTableTypeClass[]>{
    return this.http.get<SittingTableTypeClass[]>(this.path);
  }
}
