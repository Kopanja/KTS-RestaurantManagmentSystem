import { Component, OnInit } from '@angular/core';
import { Role } from '../model/role';
import { User } from '../model/user';
import { UserRegistration } from '../model/user-registration';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit {

  public userRegistration: UserRegistration = {user : {firstname : "", lastname : "", salaryAmount : "", role : ""}, username : "", password : "", pin : ""};
  public roles : Role[];
  public selectedRole : string;
  public isManagement : boolean;
  public isEmployee : boolean;
  public fail : boolean;
  public errorMsg : string;
  constructor(private authenticationService : AuthenticationService, private router:Router) { 
    this.isEmployee = false;
    this.isManagement = false;
  }

  ngOnInit(): void {
    this.authenticationService.getAllRoles().subscribe(data => {
      this.roles = data;
    })
  }


  onChange(role:any) {
    if(role === "ADMIN" || role === "MANAGER"){
      this.isManagement = true;
      this.isEmployee = false;
    }else{
      this.isEmployee = true;
      this.isManagement = false;
    }
    this.userRegistration.user.role = role;
 }

 checkInputFields():boolean{
   if(this.userRegistration.user.firstname === ""){
     this.errorMsg = "Please Enter Employees First Name";
     return false;
   }
   else if(this.userRegistration.user.lastname === ""){
    this.errorMsg = "Please Enter Employees Last Name";
    return false;
   }
   else if(this.userRegistration.user.salaryAmount === "" || isNaN(Number(this.userRegistration.user.salaryAmount))){
    this.errorMsg = "Please Enter Valid Salary";
    return false;
 }
 else if(this.userRegistration.user.role === ""){
  this.errorMsg = "Please Pick Employee Role";
  return false;
}
else if(this.isManagement){
  if(this.userRegistration.username === "" || this.userRegistration.password === ""){
    this.errorMsg = "Please Enter Username and password";
    return false;
  }  
}
else if(this.isEmployee){
  if(this.userRegistration.pin === ""){
    this.errorMsg = "Please Enter PIN";
    return false;
  } 
}
return true;
}

 save(){
   this.fail = false;
   this.errorMsg = "";
  if(this.checkInputFields()){
    console.log(this.userRegistration);
   this.authenticationService.registerNewUser(this.userRegistration).subscribe(
    (data:boolean)=>{
         
    },
    (err:Error)=>{
     
      if(err.toString() === 'Credential already taken'){
        this.fail = true;
        this.errorMsg = "Credential already taken";
      }else{
        Observable.throwError(err);
      }
    }
   );
  }else{
    this.fail = true;
  }
   
 }

}
