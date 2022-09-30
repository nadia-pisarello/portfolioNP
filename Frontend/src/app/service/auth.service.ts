import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtDto } from '../model/jwt-dto';
import { LoginUser } from '../model/login-user';
import { NewUser } from '../model/new-user';
//import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  URL = environment.URL;
  userName: BehaviorSubject<any>;
  constructor(private httpClient: HttpClient) { 
    this.userName = new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('token')|| '{}'));
  }

  public new(newUser: NewUser): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'new', newUser);
  }

  public login(loginUser: LoginUser): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.URL + 'login', loginUser)
  }

  sendCredentials(userName: string, password: string): void{
    console.log(userName, password);
  }
  // register(credenciales:any):Observable<any>{
  //   return this.http.post(this.URL, credenciales);
  // }

  token(){
    console.log("Archivo Autenticacion Service, token(): ", sessionStorage.getItem('token') );
    return  sessionStorage.getItem('token');
  }

  setToken(token:string): void {
    sessionStorage.setItem('token', token);
  }

  removeToken(): void {
    sessionStorage.removeItem('token');
    console.log("Token removed", sessionStorage.getItem('token'));
  }
}
