import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  message = 'Welcome Hanuman';
  name = 'name';
  welcomeMessage: string;
  errorMessage: string;

  constructor(
    private route: ActivatedRoute,
    private service: WelcomeDataService
  ) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage() {
    console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldBeanService().subscribe( 
      response => this.handleSuccessFulReponse(response),
      error =>this.handleErrorReponse(error),
    );
    console.log(' LAST LINE ');
  }

  getWelcomeMessageWithPath() {
    console.log(this.service.executeHelloWorldBeanService()); 
    this.service.executeHelloWorldBeanServiceWithPath('Ganesh').subscribe(
      response => this.handleSuccessFulReponse(response),
      error =>this.handleErrorReponse(error),
    );
    console.log(' LAST LINE With path');
  }

  handleSuccessFulReponse(response){
    this.welcomeMessage = response.message;
  }

  handleErrorReponse(error){
    this.errorMessage = error.error.message;
  }

}
