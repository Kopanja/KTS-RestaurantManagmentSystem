import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtUtilServiceService } from './jwt-util-service.service';
import { LoginResponse } from '../model/login-response';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly loginUsrnPassPath = 'http://localhost:8080/api/auth/usrn-pass-login';
  private readonly loginPinPath = 'http://localhost:8080/api/auth/pin-login';
  private loginResponse : LoginResponse;
  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilServiceService) { }

  loginUsrnPass(username: string, password: string) {
    //localStorage.removeItem("token");
    //localStorage.removeItem("loggedInUser");
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<LoginResponse>(this.loginUsrnPassPath, JSON.stringify({ username, password }), { headers }).subscribe(data =>{
      this.loginResponse = data;
      console.log(this.loginResponse)
    let jwtData = this.loginResponse.jwt.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    console.log(decodedJwtJsonData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData)
    console.log(decodedJwtData);
    console.log(decodedJwtData.role);
    sessionStorage.setItem("token", this.loginResponse.jwt);
    sessionStorage.setItem("loggedInUser", JSON.stringify(this.loginResponse.user));

    });
  }

  loginPin(pin: string) {
    //localStorage.removeItem("token");
    //localStorage.removeItem("loggedInUser");
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<LoginResponse>(this.loginPinPath, JSON.stringify({ pin }), { headers }).subscribe(data =>{
      this.loginResponse = data;
      console.log(this.loginResponse)
    let jwtData = this.loginResponse.jwt.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    console.log(decodedJwtJsonData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData)
    console.log(decodedJwtData);
    console.log(decodedJwtData.role);
    sessionStorage.setItem("token", this.loginResponse.jwt);
    sessionStorage.setItem("loggedInUser", JSON.stringify(this.loginResponse.user));

    });
  }

  getToken(): String {
    
    //let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    //let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    //var token = currentUser && currentUser.token;
   // return token ? token : "";
   return "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    if (this.getToken() != '') return true;
    else return false;
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return undefined;
    }
  }
}
