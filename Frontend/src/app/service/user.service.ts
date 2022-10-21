import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly URL = 'http://localhost:8080/api/v1';

  // Headers =>>> POST, PUT Y DELETE.
  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*' });
    
  constructor(private http: HttpClient) { }
  getUser(): Observable<user>{
    return this.http.get<user>(this.URL + '/profile/getProfile');
  }

  putUser( id: Number, user: user ):Observable<user> {
    return this.http.put<user>( this.URL + "/profile/update/" + id, user , { headers: this.headers} );
  }

  getUserData():Observable<user[]> {
    return this.http.get<user[]>( this.URL + "/profile/getAll");
  }
}
