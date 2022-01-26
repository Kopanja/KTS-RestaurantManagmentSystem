import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-dev-page',
  templateUrl: './dev-page.component.html',
  styleUrls: ['./dev-page.component.css']
})
export class DevPageComponent implements OnInit {

  constructor(private router : Router, private http : HttpClient) { }

  ngOnInit(): void {
  }

  changeToCreatorTool(){
    this.router.navigate(['/create-layout']);
  }

  changeToFloorLayout(){
    this.router.navigate(['/floor-layout']);
  }

  changeToBartender(){
    this.router.navigate(["/bartender"]);
  }
  changeToCook(){
    this.router.navigate(["/cook"]);
  }

  managerMenu() {
    this.router.navigate(['/menager'])
  }

  resetDB(){
    this.http.get<string>("http://localhost:8080/api/restaurant/reset-db").subscribe(data => {console.log(data)});
  }

  changeToUsrnPassLogin(){
    this.router.navigate(['/usr-pass-login'])
  }

  changeToPinLogin(){
    this.router.navigate(['/pin-login'])
  }

}
