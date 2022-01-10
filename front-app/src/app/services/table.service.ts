import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SittingTableClass } from '../model/sitting-table-class.model';
@Injectable({
  providedIn: 'root'
})
export class TableService {

  private readonly path = "http://localhost:8080/api/restaurant";
  
  constructor(private http : HttpClient) { }

  submitTableLayout(sittingTableList : SittingTableClass[]){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.path + "/table-layout", JSON.stringify(sittingTableList), {headers});

  }

  getTableLayout(floorName:string):Observable<SittingTableClass[]>{
    return this.http.get<SittingTableClass[]>(this.path + "/" + floorName + "/table-layout");
  }

  deleteTableLayout(){
    console.log("USAO");
    return this.http.delete(this.path + "/deleteAll");
  }
}
