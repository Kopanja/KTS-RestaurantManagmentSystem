import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login-usrn-pass',
  templateUrl: './login-usrn-pass.component.html',
  styleUrls: ['./login-usrn-pass.component.css']
})
export class LoginUsrnPassComponent implements OnInit {

  public user:any;

  public wrongUsernameOrPass:boolean;
  constructor(private authenticationService:AuthenticationService, private router: Router) {
    this.user = {};
    this.wrongUsernameOrPass = false;
   }

  ngOnInit(): void {
  }

  login():void{
    this.authenticationService.login(this.user.name, this.user.password);
  }

}
