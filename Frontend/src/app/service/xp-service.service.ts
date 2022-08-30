import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experience } from '../model/experience';

@Injectable({
  providedIn: 'root',
})
export class XpServiceService {
  xpURL = 'http://localhost:8080/workXp/';

  constructor(private httpClient: HttpClient) {}

  public listar(): Observable<Experience[]> {
    return this.httpClient.get<Experience[]>(this.xpURL + 'list');
  }
  public detail(id: number): Observable<Experience>{
    return this.httpClient.get<Experience>(this.xpURL + `detail/{id}`);
  }

  public save(experience: Experience): Observable<any>{
    return this.httpClient.post<any>(this.xpURL + `create` , experience);
  }
  public update(id: number, experience: Experience): Observable<any>{
    return this.httpClient.put<any>(this.xpURL + `update/${id}`, experience);
  }
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.xpURL + `delete/${id}`);
  }
}
