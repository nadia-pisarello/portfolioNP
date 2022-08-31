
import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { XpServiceService } from 'src/app/service/xp-service.service';
import { Experience } from 'src/app/model/experience';

@Component({
  selector: 'app-work-xp',
  templateUrl: './work-xp.component.html',
  styleUrls: ['./work-xp.component.css']
})
export class WorkXpComponent implements OnInit {
  experience: Experience[] = [];

  constructor(private xpService: XpServiceService, private tokenService: TokenService) { }
  isLogged = false;
  
  ngOnInit(): void {
    this.loadExperience();
    if(this.tokenService.getToken()){
      this.isLogged= true;
    } else {
      this.isLogged = false;
    }
    
  }
  loadExperience(): void {
    this.xpService.listar().subscribe(data => {this.experience = data});      
    
  }
  delete(id?: number){
    if(id != undefined){
      this.xpService.delete(id).subscribe(
        data => this.loadExperience(),
        err => alert("the operation could not be completed")   
      )
    }
  }
  
}


