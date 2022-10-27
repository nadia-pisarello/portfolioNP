import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profile } from 'src/app/model/profile';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { UploadService } from 'src/app/service/upload.service';

@Component({
  selector: 'app-update-about',
  templateUrl: './update-about.component.html',
  styleUrls: ['./update-about.component.css']
})
export class UpdateAboutComponent implements OnInit {
  profile: Profile = null;
  constructor(private profileService: PortfolioService, private activated: ActivatedRoute,
    private router: Router, public uploadService: UploadService) { }

  ngOnInit(): void {
    const id = this.activated.snapshot.params['id'];
    this.profileService.getOneProfile(id).subscribe(
      data => {
        this.profile = data;
      }
    )
  }

  onUpdate() {
    const id = this.activated.snapshot.params['id'];
    this.profileService.putProfile(id, this.profile).subscribe(
      data => {
        this.router.navigate(['']);
      } 
    )
  }

  selectFile($event: any){
    const id = this.activated.snapshot.params['id'];
    const name = 'profile_'+ id ;
    this.uploadService.uploadFile($event,name);
  }

  // onUpload(){
    
  // }
}

