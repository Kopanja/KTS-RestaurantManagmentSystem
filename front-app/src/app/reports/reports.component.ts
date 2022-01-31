import { Component, OnInit } from '@angular/core';
import { ReportService } from '../services/report.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  public menuLinks : Map<string,string>;
  public fileNames : string[];
  constructor(private reportService : ReportService) {
    this.menuLinks =  new Map<string, string>();
    this.fileNames = [];
   }

  ngOnInit(): void {
    this.getLinks();
  }

  getLinks(){
    this.menuLinks = new Map<string, string>();
    this.fileNames = [];
    this.reportService.getReportLinks().subscribe(data => {
      //console.log(data);
      data.forEach(element => {
        console.log(element);
        let splitLink : string[] = element.split("/");
        let fileName :string = splitLink[splitLink.length-1];
        this.menuLinks.set(fileName,element);
        this.fileNames.push(fileName);
      });
    })

  }

  goToLink(fileName:string){
    let url = this.menuLinks.get(fileName);
    window.open(url, "_blank");
  }

  generateNewSalaryReport(){
      this.reportService.generateNewSalaryPayoutReport().subscribe(data => {
        this.getLinks();
      })
  }

}
