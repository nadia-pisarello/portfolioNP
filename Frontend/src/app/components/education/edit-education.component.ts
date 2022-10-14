import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { PortfolioService } from 'src/app/service/portfolio.service';

@Component({
  selector: 'app-edit-education',
  templateUrl: './edit-education.component.html',
  styleUrls: ['./edit-education.component.css']
})
export class EditEducationComponent implements OnInit {
  education: Education = null;

  constructor(private educationService: PortfolioService, private activated: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activated.snapshot.params['id'];
    this.educationService.getOneEducationData(id).subscribe(
      data => {
        this.education = data;
      }
    )
  }

  onUpdate() {
    const id = this.activated.snapshot.params['id'];
    this.educationService.putEducation(id, this.education).subscribe(
      data => {
        this.router.navigate(['']);
      }
    )
  }

}
