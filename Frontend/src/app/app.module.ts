import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { ProyectComponent } from './components/proyect/proyect.component';
import { FooterComponent } from './components/footer/footer.component';
import { InterceptorProviderService } from './service/interceptor-provider.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { EducationComponent } from './components/education/education.component';
import { SkillComponent } from './components/skill/skill.component';
import { EditExperienceComponent } from './components/experience/edit-experience.component';
import { EditEducationComponent } from './components/education/edit-education.component';
import { EditSkillComponent } from './components/skill/edit-skill.component';
import { EditProyectComponent } from './components/proyect/edit-proyect.component';
import { UpdateAboutComponent } from './components/about-me/update-about.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutMeComponent,
    ProyectComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    ExperienceComponent,
    EducationComponent,
    SkillComponent,
    EditExperienceComponent,
    EditEducationComponent,
    EditSkillComponent,
    EditProyectComponent,
    UpdateAboutComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule, 
    HttpClientModule,
    AppRoutingModule,       
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: InterceptorProviderService,
    multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
