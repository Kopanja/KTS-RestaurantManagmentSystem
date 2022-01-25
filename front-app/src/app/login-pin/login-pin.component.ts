import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
@Component({
  selector: 'app-login-pin',
  templateUrl: './login-pin.component.html',
  styleUrls: ['./login-pin.component.css']
})
export class LoginPinComponent implements OnInit {
  public user:any;
  public wrongPin:boolean;
  constructor(private authenticationService:AuthenticationService, private router: Router) {
    this.user = {};
    this.wrongPin = false;
   }

  ngOnInit(): void {
  }

  login():void{
    this.authenticationService.loginPin(this.user.pin);
  }

}
