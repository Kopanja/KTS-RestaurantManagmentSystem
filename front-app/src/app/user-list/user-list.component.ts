import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { Router } from '@angular/router';
import { isError } from 'util';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  public activeUsers : User[];
  public firedUsers : User[];
  constructor(private userService : UserService, private router:Router ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.userService.getAllUsers().subscribe(data => {
      this.activeUsers = [];
      this.firedUsers = [];
      data.forEach(element => {
        if(element.active){
          this.activeUsers.push(element)
        }else{
          this.firedUsers.push(element);
        }
      });
    
    })
  }
  editClick(user:User){
    console.log(user);
    this.router.navigate(['/user/',user.id]);
  }

  fireClick(user:User){
    this.userService.fire(user).subscribe(
      data => {
        this.getUsers();
      }
    )
  }

}
