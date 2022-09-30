import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  
  constructor(private asAuthService: AuthService){

  }
  // constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router){
  //   this.form = this.formBuilder.group({
  //     userName: ['', [Validators.required, Validators.minLength(6)]],
  //     password: ['', [Validators.required, Validators.minLength(8)]]
  
  //   })
  // }
  ngOnInit(): void {
    this.form = new FormGroup(
      {
      userName: new FormControl('', [Validators.required, Validators.minLength(6)]),
      password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(12)])
      }
    )
    
  }

  get userName(){
    return this.form.get('userName');
  }

  get password(){
    return this.form.get('password');
  }

  // onLogin(event: Event): void{
  //   event.preventDefault;
  //   this.authService.login(this.form.value).subscribe(
  //     data => { 
  //       console.log(data.token);
  //       sessionStorage.setItem('token', data.token);
  //       this.authService.setToken(data.token);
  //       this.router.navigate(['home']);
  //     }, err =>{
        
  //       console.log('Error al iniciar');
  //     })
    
  // }

  sendLogin(): void {
    const {userName, password} = this.form.value;
    this.asAuthService.sendCredentials(userName, password)
    console.log('Me vuelvo chango')
  }

}
