import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorProviderService implements HttpInterceptor{

  constructor(private tokenService: TokenService, private router: Router) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
    
    //Obtenemos el token
    const token = this.tokenService.getToken();
    let request = req;
    //Se agrega content type
    request = req.clone({ headers: request.headers.set('Content-Type', 'application/json') });
    if(token){
      request = req.clone({
        headers: req.headers.set('Authorization', 'Bearer' + token)
      });
    }
    //Se envía petición y con pipe catcError verificamos si request tira error para redirigirlo en caso de token doesn't exists o vencido
    return next.handle(request).pipe(
      catchError((err:HttpErrorResponse) => {
        if(err.status === 401){
          this.router.navigateByUrl('/err401');
        }
        return throwError(err);
      })
    );
  }
}
