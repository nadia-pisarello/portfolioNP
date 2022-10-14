import { Component, OnInit } from '@angular/core';
import { Proyect } from 'src/app/model/proyect';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyect',
  templateUrl: './proyect.component.html',
  styleUrls: ['./proyect.component.css']
})
export class ProyectComponent implements OnInit {

  portfolio: Proyect[] = [];
  _isLogged: boolean = false;
  _isEdit: boolean = false;
  title: string;
  description: string;
  image: string;

  constructor(private proyectService: PortfolioService, private token: TokenService) { }

  ngOnInit(): void {
    this.loadProyect();
    if (this.token.getToken()) {
      this._isLogged = true;
    } else this._isLogged = false;
  }

  loadProyect() {
    this.proyectService.getProyectData().subscribe(data => {
      this.portfolio = data;
      console.log(this.portfolio);
    })
  }

  delete(id?: number) {
    if (id != undefined) {
      this.proyectService.deleteProyect(id).subscribe(
        data => {
          this.loadProyect();
        }
      )
    }
  }

  onCreate(event: Event): void {
    const NewProyect = new Proyect(this.title, this.description, this.image);
    this.proyectService.postProyecto(NewProyect).subscribe(
      data => {
        alert("Successful operation");
        window.location.reload();
      }
    )
  }
}
