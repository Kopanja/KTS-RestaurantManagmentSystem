import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly path = "http://localhost:8080/api/user";
  constructor(private http : HttpClient) { }

  getAllUsers():Observable<User[]>{
    return this.http.get<User[]>(this.path + "/getAll");
  }
}
