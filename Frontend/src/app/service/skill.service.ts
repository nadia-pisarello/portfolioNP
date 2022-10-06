import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill } from '../model/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  URL = 'http://localhost:8080/api/v1';
  
  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.URL + '/skill/list');
  }

  public detail(id: number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.URL + `/skill/detail/${id}`);
  }

  public save(skill: Skill): Observable<any>{
    return this.httpClient.post<any>(this.URL + '/skill/create', skill);
  }

  public update(id: number, skill: Skill): Observable<any>{
    return this.httpClient.put<any>(this.URL + `/skill/update/${id}`, skill);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete(this.URL + `/skill/delete/${id}`);
  }
}
