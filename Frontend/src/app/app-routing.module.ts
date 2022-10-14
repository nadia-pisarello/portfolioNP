import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEducationComponent } from './components/education/edit-education.component';
import { EditExperienceComponent } from './components/experience/edit-experience.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectComponent } from './components/proyect/edit-proyect.component';
import { EditSkillComponent } from './components/skill/edit-skill.component';


const routes: Routes = [

  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent}, 
  {path: 'editExperience/:id', component: EditExperienceComponent},
  {path: 'editEducation/:id', component: EditEducationComponent},
  {path: 'editSkill/:id', component: EditSkillComponent},
  {path: 'editProyect/:id', component: EditProyectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
