import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { XpServiceService } from 'src/app/service/xp-service.service';

@Component({
  selector: 'app-new-experience',
  templateUrl: './new-experience.component.html',
  styleUrls: ['./new-experience.component.css']
})
export class NewExperienceComponent implements OnInit {
  xp_name: string = "";
  xp_descrip: string = "";
  constructor(private xpService: XpServiceService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const xp = new Experience(this.xp_name, this.xp_descrip);
    this.xpService.save(xp).subscribe
    (data=> {
      alert("Successful operation");
      this.router.navigate(['']);

    }, err =>{
         alert('Failed');
         this.router.navigate(['']);
    })
  }

}
