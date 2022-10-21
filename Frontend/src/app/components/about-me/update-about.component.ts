import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from 'src/app/model/user.model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-update-about',
  templateUrl: './update-about.component.html',
  styleUrls: ['./update-about.component.css']
})
export class UpdateAboutComponent implements OnInit {
  user: user = null;
  constructor(private userService: UserService, private activated: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activated.snapshot.params['id'];
    this.userService.getUser().subscribe(
      data => {
        this.user = data;
      }
    )
  }

  onUpdate() {
    const id = this.activated.snapshot.params['id'];
    this.userService.putUser(id, this.user).subscribe(
      data => {
        this.router.navigate(['']);
      }, next =>{
        this.router.navigate(['']);
      }
    )
  }

  uploadFile($event: any){

  }
}
