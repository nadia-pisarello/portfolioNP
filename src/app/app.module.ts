import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoApComponent } from './components/logo-ap/logo-ap.component';
import { BannerComponent } from './components/banner/banner.component';
import { MediaComponent } from './components/media/media.component';
import { SkillsComponent } from './components/skills/skills.component';
import { EducationComponent } from './components/education/education.component';
import { WorkXpComponent } from './components/work-xp/work-xp.component';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { ProyectComponent } from './components/proyect/proyect.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoApComponent,
    BannerComponent,
    MediaComponent,
    SkillsComponent,
    EducationComponent,
    WorkXpComponent,
    AboutMeComponent,
    ProyectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
