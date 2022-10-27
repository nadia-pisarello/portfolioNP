import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/model/profile';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-about-me',
  templateUrl: './about-me.component.html',
  styleUrls: ['./about-me.component.css']
})
export class AboutMeComponent implements OnInit {
  _isLogged: boolean = false;
  profile: Profile = new Profile("","","","","");
  constructor(public profileServ: PortfolioService, private token: TokenService) { }

  ngOnInit(): void {
    this.loadUser()
    if (this.token.getToken()) {
      this._isLogged = true;
    } else this._isLogged = false;
  }

  loadUser(){
    this.profileServ.getOneProfile(1).subscribe(data => {this.profile = data})
  }

}
