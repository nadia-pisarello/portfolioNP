import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-neweducation',
  templateUrl: './newEducation.component.html',
  styleUrls: ['./newEducation.component.css']
})
export class NewEducationComponent implements OnInit {
  nameE: string;
  descriptionE: string;

  constructor(private educationServ: EducationService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const education = new Education(this.nameE, this.descriptionE);
    this.educationServ.save(education).subscribe(
      data =>{
        alert("Successful operation");
        this.router.navigate(['']);        
      }, err =>{
        alert("Failed");
        this.router.navigate([''])
      }
    )
  }
}
