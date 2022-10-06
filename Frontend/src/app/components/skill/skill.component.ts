import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  skillL: Skill[] = [];
  name: string;
  skill: Skill = null;
  _isEdit: boolean = false;
  _isCreate: boolean = false;

  constructor(private skillS: SkillService, private tokenService: TokenService, private router: Router, private activatedRoute: ActivatedRoute) { }
  isLogged = false;

  ngOnInit(): void {
    this.loadSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  loadSkills(): void {
    this.skillS.list().subscribe(
      data => {
        this.skillL = data;
      }
    )
  }

  delete(id: number) {
    if (id != undefined) {
      this.skillS.delete(id).subscribe(
        data => {
          this.loadSkills();
        }, err => {
          alert("Failed operation");
        }
      )
    }
  }
  onCreate(): void {
    
    const skillK = new Skill(this.name);
    this.skillS.save(skillK).subscribe(
      data => {
        alert("Successful operation");
        this.router.navigate(['']);
      }, err => {
        alert("Failed operation");
        this.router.navigate(['']);
      }
    )
    this._isCreate = true;
  }

  onUpdate(){
    
    const id = this.activatedRoute.snapshot.params['id'];
    this.skillS.update(id, this.skill).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Failed Operation");
        this.router.navigate(['']);
      }
    )
    this._isEdit = true;
  }

}
