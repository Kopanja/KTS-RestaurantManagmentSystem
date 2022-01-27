import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  public user:User;
  constructor(private route: ActivatedRoute,private userService : UserService) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      let id = params.id;
      this.userService.getById(id).subscribe(data =>{
        this.user = data;
      });
    });

  }
}
