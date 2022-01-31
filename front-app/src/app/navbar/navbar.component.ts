import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authenticationService : AuthenticationService,private router : Router) { }

  ngOnInit(): void {
  }

  changeEmployeeClick(){
    this.authenticationService.logout();
    this.router.navigate(['']);
    
  }

  isAdmin():boolean{
  
    if(this.authenticationService.getLoggedInUserRole().authority === "ADMIN"){
      return true;
    }else{
      return false;
    }
  }

  isManager():boolean{
    if(this.authenticationService.getLoggedInUserRole().authority === "MANAGER"){
      return true;
    }else{
      return false;
    }
  }

  isLoggedIn():boolean{
    return this.authenticationService.isLoggedIn();
  }

}
