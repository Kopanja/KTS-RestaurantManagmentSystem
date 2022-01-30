import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { ActivatedRoute } from '@angular/router';
import { Role } from '../model/role';
import { AuthenticationService } from '../services/authentication.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  public user:User;
  public roles : Role[];
  public selectedRole : string;
  constructor(private route: ActivatedRoute,private userService : UserService, private authenticationService : AuthenticationService) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      let id = params.id;
      this.userService.getById(id).subscribe(data =>{
        this.user = data;
      });
    });
    this.authenticationService.getAllRoles().subscribe(data => {
      this.roles = data;
    })

  }
  onChange(role:any) {
    this.user.role = role;
    console.log(this.user.role);
 }
  save(){
    console.log(this.user);
    this.userService.update(this.user).subscribe();
  }
}
