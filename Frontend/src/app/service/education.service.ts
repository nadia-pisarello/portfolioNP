import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Education } from '../model/education';

@Injectable({
    providedIn: 'root',
  })
  export class EducationService {
    URL = 'http://localhost:8080/api/v1';
  
    constructor(private httpClient : HttpClient) {}

    public listar(): Observable<Education[]> {
        return this.httpClient.get<Education[]>(this.URL + '/education/list');
      }
      public detail(id: number): Observable<Education>{
        return this.httpClient.get<Education>(this.URL + `/education/detail/{id}`);
      }
    
      public save(education: Education): Observable<any>{
        return this.httpClient.post<any>(this.URL + `/education` , education);
      }
      public update(id: number, education: Education): Observable<any>{
        return this.httpClient.put<any>(this.URL + `/education/update/${id}`, education);
      }
      public delete(id: number): Observable<any>{
        return this.httpClient.delete<any>(this.URL + `/education/delete/${id}`);
      }
  }