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

  public badLogin:boolean;
  public errorMsg:string;
  constructor(private authenticationService:AuthenticationService, private router: Router) {
    this.user = {name : "", password : ""};
    this.badLogin = false;
   }

  ngOnInit(): void {
  }

  login():void{
    this.badLogin = false;
    this.errorMsg = "";
    console.log(this.user.name);
    if(this.user.name === "" || this.user.password === ""){
      this.errorMsg = "Username or Password missing";
      this.badLogin = true;
      
    }else{
      this.authenticationService.loginUsrnPass(this.user.name, this.user.password).subscribe(
        (loggedIn:boolean)=>{},
        (err:Error)=>{
          if(err.toString() === 'Bad credentials'){
            this.badLogin = true;
            this.errorMsg = "Bad credentials";
          }else{
            Observable.throwError(err);
          }
        }
      );
    }
    
  }

}
