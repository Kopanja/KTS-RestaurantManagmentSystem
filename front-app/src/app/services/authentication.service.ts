import { Observable } from 'rxjs/Rx';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtUtilServiceService } from './jwt-util-service.service';
import { LoginResponse } from '../model/login-response';
import { Router } from '@angular/router';
import { UserRegistration } from '../model/user-registration';
import { Role } from '../model/role';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly loginUsrnPassPath = 'http://localhost:8080/api/auth/usrn-pass-login';
  private readonly loginPinPath = 'http://localhost:8080/api/auth/pin-login';
  private readonly registrationPath = 'http://localhost:8080/api/auth/register';
  private readonly rolesPath = 'http://localhost:8080/api/role/getAll';
  private loginResponse : LoginResponse;
  constructor(private http: HttpClient,private router : Router, private jwtUtilsService: JwtUtilServiceService) { }

  loginUsrnPass(username: string, password: string) :Observable<boolean> {
    //localStorage.removeItem("token");
    //localStorage.removeItem("loggedInUser");
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<LoginResponse>(this.loginUsrnPassPath, JSON.stringify({ username, password }), { headers })
    .map((data:any) =>{
      this.loginResponse = data;
    
      let jwtData = this.loginResponse.jwt.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
    
      let decodedJwtData = JSON.parse(decodedJwtJsonData)
    //console.log(this.jwtUtilsService.getRoles(this.loginResponse.jwt));
    if(this.loginResponse.jwt){
      sessionStorage.setItem("token", this.loginResponse.jwt);
    sessionStorage.setItem("loggedInUser", JSON.stringify(this.loginResponse.user));
    console.log(this.getLoggedInUserRole());
    this.redirectLoggedInUser();
      return true;
    }else{
      return false;
    }
    

    })
    .catch((error:any) =>{
      if(error.status === 403){
        return Observable.throwError("Bad credentials")
      }else{
        return Observable.throwError(error.json().error || 'Server error');
      }
    });
  }
  loginPin(pin: string) :Observable<boolean> {
    
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<LoginResponse>(this.loginPinPath, JSON.stringify({ pin }), { headers })
    .map((data:any) =>{
      this.loginResponse = data;
    
      //let jwtData = this.loginResponse.jwt.split('.')[1];
      //let decodedJwtJsonData = window.atob(jwtData);
    
      //let decodedJwtData = JSON.parse(decodedJwtJsonData)
    //console.log(this.jwtUtilsService.getRoles(this.loginResponse.jwt));
    console.log(this.loginResponse.jwt);
    if(this.loginResponse.jwt){
      sessionStorage.setItem("token", this.loginResponse.jwt);
    sessionStorage.setItem("loggedInUser", JSON.stringify(this.loginResponse.user));
    console.log(this.getLoggedInUserRole());
    this.redirectLoggedInUser();
      return true;
    }else{
      return false;
    }
    

    })
    .catch((error:any) =>{
      console.log(error);
      if(error.status === 403){
        return Observable.throwError("Bad credentials")
      }else{
        return Observable.throwError(error.json().error || 'Server error');
      }
    });
  }

  registerNewUser(registrationRequest: UserRegistration) {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.registrationPath, JSON.stringify(registrationRequest), { headers }).subscribe();
  }

  getToken(): String {
   return sessionStorage.token;
  }

  logout(): void {
   localStorage.removeItem("token");
  localStorage.removeItem("loggedInUser");
  }

  isLoggedIn(): boolean {
    if (this.getToken() != '') return true;
    else return false;
  }

  getLoggedInUserRole(){
    if(sessionStorage.currentUser !== null && sessionStorage.token !== ""){
      return this.jwtUtilsService.getRoles(sessionStorage.token)[0];
    }
    return null;
  }
  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(sessionStorage.currentUser);
    }
    else {
      return undefined;
    }
  }

  redirectLoggedInUser(){
  
    const userRole = this.getLoggedInUserRole();
    if(userRole){

      if(userRole.authority === "ADMIN"){
        this.router.navigate(["/admin"]);
      }else if(userRole.authority === "MENAGER"){
        this.router.navigate(["/menager"])
      }else if(userRole.authority === "COOK"){
        this.router.navigate(["/cook"])
      }else if(userRole.authority === "BARTENDER"){
        this.router.navigate(["/bartender"])
      }else if(userRole.authority === "WAITER"){
        this.router.navigate(["/waiter"])
      }

    }else{
      this.router.navigate(["/home"])
    }
    
  }

  getAllRoles():Observable<Role[]>{
    return this.http.get<Role[]>(this.rolesPath);
  }
}
