import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';

export class HelloWorldBean {

  // private String message;

  // public String getMessage() {
  // 	return message;
  // }

  constructor(public message: string) {
  }

}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http: HttpClient
  ) { }

  executeHelloWorldBeanService() {
    return this.http.get<HelloWorldBean>(`${API_URL}/hello-world-bean`);
    //console.log('WelcomeDataService');
  }

  executeHelloWorldBeanServiceWithPath(name) {
    //let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString 
    // });
    return this.http.get<HelloWorldBean>(`${API_URL}/hello-world-bean/${name}`,
    // {headers}
    );
    //console.log('WelcomeDataService');
  } 

  // createBasicAuthenticationHttpHeader() {
  //   let username = 'Ganesh';
  //   let password = 'dummy';
  //   let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
  //   return basicAuthHeaderString;
  // }
}
