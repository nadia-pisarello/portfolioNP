import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { PortfolioService } from 'src/app/service/portfolio.service';

@Component({
  selector: 'app-edit-experience',
  templateUrl: './edit-experience.component.html',
  styleUrls: ['./edit-experience.component.css']
})
export class EditExperienceComponent implements OnInit {
  experience: Experience = null;

  constructor(private experiencePort: PortfolioService, private activated: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activated.snapshot.params['id'];
    this.experiencePort.getOneExperience(id).subscribe(
      data => {
        this.experience = data;
      }
    )

  }

  onUpdate() {
    const id = this.activated.snapshot.params['id'];
    this.experiencePort.putExperience(id, this.experience).subscribe(
      data => {
        this.router.navigate(['']);
      }
    )
  }
}
