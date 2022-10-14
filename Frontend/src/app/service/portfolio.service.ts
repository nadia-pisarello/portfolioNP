import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Education } from '../model/education';
import { Experience } from '../model/experience';
import { Proyect } from '../model/proyect';
import { Skill } from '../model/skill';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  private readonly URL = 'http://localhost:8080/api/v1';

    // Headers =>>> POST, PUT Y DELETE.
    headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*' });
  
  
    constructor(private http:HttpClient) { }
  
    
    // ******************   |  GET ALL    | **************************
   
    getExperienceData():Observable<Experience[]> {
      return this.http.get<Experience[]>(`${this.URL}/experience/list`, {responseType: 'json'}).pipe(catchError(this.getExperienceData));
    }
  
    getEducationData():Observable<Education[]> {
      return this.http.get<Education[]>( `${this.URL}/education/list`, {responseType: 'json'}).pipe(catchError(this.getEducationData));
    }
  
    getSkillData():Observable<Skill[]> {
      return this.http.get<Skill[]>( `${this.URL}/skill/list`, {responseType: 'json'}).pipe(catchError(this.getSkillData));
    }
  
    getProyectData():Observable<Proyect[]> {
      return this.http.get<Proyect[]>( `${this.URL}/proyect/list`, {responseType: 'json'}).pipe(catchError(this.getProyectData));
    }

    // **************   |   METHOD'S GET ONE    | **************************
  
    getOneExperience(id: number):Observable<Experience> {
      return this.http.get<Experience>( this.URL + "/experience/" + id);
    }

    getOneEducationData(id: number):Observable<Education> {
      return this.http.get<Education>( this.URL + '/education/' + id);
    }
     
    getOneSkill(id: number):Observable<Skill> {
      return this.http.get<Skill>( this.URL + '/skill/' + id);
    }

    getOneProyect(id: number):Observable<Proyect> {
      return this.http.get<Proyect>( this.URL + '/proyect/' + id);
    }
  
    // **************   |   METHOD'S POST    | ******************************
 
    postExperience( Experience: Experience ):Observable<Experience> {
      return this.http.post<Experience>( this.URL + "/experience", Experience , { headers: this.headers} );
    }
  
    postEducation( Education: Education ):Observable<Education> {
      return this.http.post<Education>( this.URL + '/education', Education , { headers: this.headers} );
    }  
  
    postSkill( Skill: Skill ):Observable<Skill> {
      return this.http.post<Skill>( this.URL + '/skill', Skill , { headers: this.headers} );
    }
   
    postProyecto( Proyect: Proyect ):Observable<Proyect> {
      return this.http.post<Proyect>( this.URL + '/proyect', Proyect , { headers: this.headers} );
    }
    // **************   |   METHOD'S PUT    | ******************************
  
    putExperience( id: Number, Experience: Experience ):Observable<Experience> {
      return this.http.put<Experience>( this.URL + "/experience/" + id, Experience , { headers: this.headers} );
    }
      
    putEducation( id: Number, Education: Education ):Observable<Education> {
      return this.http.put<Education>( this.URL + '/education/' + id, Education , { headers: this.headers} );
    }
  
    putSkill( id: Number, Skill: Skill ):Observable<Skill> {
      return this.http.put<Skill>( this.URL + '/skill/' + id, Skill , { headers: this.headers} );
    }

    putProyecto( id: Number, Proyect: Proyect ):Observable<Proyect> {
      return this.http.put<Proyect>( this.URL + '/proyect/' + id, Proyect , { headers: this.headers} );
    }
  
    
    // **************   |   METHOD'S DELETE    | ***************************
  
    deleteExperience( id: Number ):Observable<Experience> {
      return this.http.delete<Experience>( this.URL + '/experience/' + id ,  { headers: this.headers} );
    }
  
    deleteEducation( id: Number ):Observable<Education> {
      return this.http.delete<Education>( this.URL + '/education/' + id , { headers: this.headers} );
    }
  
    deleteSkill( id: Number ):Observable<Skill> {
      return this.http.delete<Skill>( this.URL + '/skill/' + id ,  { headers: this.headers} );
    }
  
    deleteProyect( id: Number ):Observable<Proyect> {
      return this.http.delete<Proyect>( this.URL + '/proyect/' + id ,  { headers: this.headers} );
    }
  
  
}


