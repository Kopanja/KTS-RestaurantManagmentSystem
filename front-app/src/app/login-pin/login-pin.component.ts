import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-login-pin',
  templateUrl: './login-pin.component.html',
  styleUrls: ['./login-pin.component.css']
})
export class LoginPinComponent implements OnInit {
  public user:any;
  public badLogin:boolean;
  public errorMsg:string;
  constructor(private authenticationService:AuthenticationService, private router: Router) {
    this.user = {pin : ""};
    this.badLogin = false;
   }

  ngOnInit(): void {
  }

  login():void{
    this.badLogin = false;
    this.errorMsg = "";
    if(this.user.pin === ""){
      this.errorMsg = "Plese enter PIN";
      this.badLogin = true;
      
    }else{
      this.authenticationService.loginPin(this.user.pin).subscribe(
        (loggedIn:boolean)=>{
          if(!loggedIn){
            this.badLogin = true;
            this.errorMsg = "Bad credentials";
          }
        },
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
