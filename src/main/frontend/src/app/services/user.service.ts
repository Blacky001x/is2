import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {IUser} from "../model/IUser";
import {catchError, tap} from "rxjs/operators";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/throw'

import * as $ from 'jquery';
import {User} from "../model/user.model";

@Injectable()
export class UserService {

  private baseUrl = 'http://localhost:8080';

  private loginUrl = this.baseUrl + '/login';
  private logoutUrl = this.baseUrl + '/logout';
  private registerUrl = this.baseUrl + '/register';

  constructor(private _http: HttpClient) { }

  login(user: IUser) {
    const data = 'username=' + encodeURIComponent(user.username) +
      'password=' + encodeURIComponent(user.password);
    const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');


    // return this._http.post(this.loginUrl, data, { headers });
    return this._http.post(this.loginUrl, $.param(user), { headers });
  }

  register(user: User) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this._http.post<User>(this.registerUrl, user, { headers } );
  }

  logout() {
    return this._http.post(this.logoutUrl, {});
  }

  private handleError(error: HttpErrorResponse) {
    console.log('error: ' + error);
    return Observable.throw(error.message || 'server error');
  }
}
