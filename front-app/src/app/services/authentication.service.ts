import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtUtilServiceService } from './jwt-util-service.service';
import { LoginResponse } from '../model/login-response';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly loginPath = 'http://localhost:8080/api/auth/usrn-pass-login';
  private loginResponse : LoginResponse;
  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilServiceService) { }

  login(username: string, password: string) {
    //localStorage.removeItem("token");
    //localStorage.removeItem("loggedInUser");
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<LoginResponse>(this.loginPath, JSON.stringify({ username, password }), { headers }).subscribe(data =>{
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
    
    
    
    /*
      .map((res: any) => {
        let token = res && res['token'];
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({
            username: name,
            roles: this.jwtUtilsService.getRoles(token),
            token: token.split(' ')[1]
          }));
          return true;
        }
        else {
          return false;
        }
      })
      .catch((error: any) => {
        if (error.status === 400) {
          return Observable.throw('Ilegal login');
        }
        else {
          return Observable.throw(error.json().error || 'Server error');
        }
      });
      */
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
