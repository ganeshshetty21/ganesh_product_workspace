import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticateLogin(username, password) {
    //console.log('before ' + this.isUserLoggedIn());
    if (username === 'b' && password === '') {
      sessionStorage.setItem('authenticateUser', username);
      //console.log('after ' + this.isUserLoggedIn());
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticateUser');
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticateUser');
  }
}
