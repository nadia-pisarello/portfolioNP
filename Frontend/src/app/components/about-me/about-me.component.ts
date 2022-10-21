import { Component, OnInit } from '@angular/core';
import { user } from 'src/app/model/user.model';
import { TokenService } from 'src/app/service/token.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-about-me',
  templateUrl: './about-me.component.html',
  styleUrls: ['./about-me.component.css']
})
export class AboutMeComponent implements OnInit {
  _isLogged: boolean = false;
  user: user = new user("","","","","");
  constructor(public userService: UserService, private token: TokenService) { }

  ngOnInit(): void {
    this.loadUser()
    if (this.token.getToken()) {
      this._isLogged = true;
    } else this._isLogged = false;
  }

  loadUser(){
    this.userService.getUser().subscribe(data => {this.user = data})
  }

}
