import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experience } from '../model/experience';

@Injectable({
  providedIn: 'root',
})
export class XpServiceService {
  URL = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient) {}

  public listar(): Observable<Experience[]> {
    return this.httpClient.get<Experience[]>(this.URL + '/workXp/list');
  }
  public detail(id: number): Observable<Experience>{
    return this.httpClient.get<Experience>(this.URL + `/workXp/detail/{id}`);
  }

  public save(experience: Experience): Observable<any>{
    return this.httpClient.post<any>(this.URL + `/workXp/create` , experience);
  }
  public update(id: number, experience: Experience): Observable<any>{
    return this.httpClient.put<any>(this.URL + `/workXp/update/${id}`, experience);
  }
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `/workXp/delete/${id}`);
  }
}
