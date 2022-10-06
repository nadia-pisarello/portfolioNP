import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly URL = 'http://localhost:8080/api/v1/profile';
  constructor(private httpClient: HttpClient) { }
  public getUser(): Observable<user>{
    return this.httpClient.get<user>(this.URL + '/getProfile');
  }
}
