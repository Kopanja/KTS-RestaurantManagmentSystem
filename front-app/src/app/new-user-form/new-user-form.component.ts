import { Component, OnInit } from '@angular/core';
import { Role } from '../model/role';
import { User } from '../model/user';
import { UserRegistration } from '../model/user-registration';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit {

  public userRegistration: UserRegistration = {user : {}};
  public roles : Role[];
  public selectedRole : string;
  constructor(private authenticationService : AuthenticationService, private router:Router) { }

  ngOnInit(): void {
    this.authenticationService.getAllRoles().subscribe(data => {
      this.roles = data;
    })
  }


  onChange(role:any) {
    this.selectedRole = role;
 }

 save(){
   console.log(this.selectedRole);
   this.userRegistration.user.role = this.selectedRole;
   console.log(this.userRegistration);
   this.authenticationService.registerNewUser(this.userRegistration);
 }

}
