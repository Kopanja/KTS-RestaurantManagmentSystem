import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpEvent } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private readonly path = "http://localhost:8080/api/report";

  constructor(private http : HttpClient) { }

  getReportLinks():Observable<string[]>{
    return this.http.get<string[]>(this.path + "/report-links");
  }

  generateNewSalaryPayoutReport(){
    return this.http.get(this.path + "/salary-payout");
  }
}
