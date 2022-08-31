import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { XpServiceService } from 'src/app/service/xp-service.service';

@Component({
  selector: 'app-edit-xp',
  templateUrl: './edit-xp.component.html',
  styleUrls: ['./edit-xp.component.css']
})
export class EditXpComponent implements OnInit {
  jobXp: Experience = null;
  constructor(private xpService: XpServiceService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.xpService.detail(id).subscribe(
      data => this.jobXp = data,
      err => { alert("Error");
              this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.xpService.update(id, this.jobXp)
    .subscribe(
      data => this.router.navigate(['']),
      err => { alert("Error");
              this.router.navigate(['']);
     }
    )
  }

}
