import { Injectable } from '@angular/core';
import {UserService} from "./user.service";
import {Router} from "@angular/router";

@Injectable()
export class AuthService {

  public token: string = '';

  constructor(private _userService: UserService, private _router: Router) { }

  isAuthenticated() {
    // return localStorage.getItem('key') !== null;
    return document.cookie != null && document.cookie != '';

  }

  login(token: string) {
    document.cookie = "JSESSIONID="+token;
    // token = "JSESSIONID="+token;
    // localStorage.setItem('key', token);
  }

  logout() {
    console.log('logging out');
    document.cookie = ( document.cookie + '=; Max-Age=0' );
    this._userService.logout().subscribe(data => {
      this._router.navigate(['/home'])
    });
    // localStorage.clear();
    console.log('logged out');
  }

  getToken() {
    return document.cookie;
    // return localStorage.getItem('key');
  }

}
