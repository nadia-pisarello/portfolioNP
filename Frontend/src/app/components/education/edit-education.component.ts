import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-edit-education',
  templateUrl: './edit-education.component.html',
  styleUrls: ['./edit-education.component.css'],
})
export class EditEducationComponent implements OnInit {
  education: Education = null;

  constructor(
    private educationServ: EducationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.educationServ.detail(id).subscribe(
      data => {
        this.education = data;
      }, err => {
        alert("Failed operation");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];;
    this.educationServ.update(id, this.education).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Failed operation");
        this.router.navigate(['']);
      }
    )
  }
}
