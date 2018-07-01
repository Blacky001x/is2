import { Component, OnInit } from '@angular/core';
import {IUser} from "../../model/IUser";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: IUser;

  constructor(private _userService: UserService, private _authService: AuthService, private _router: Router) { }

  ngOnInit() {
    this.user = {username: '', password: ''}
  }

  onSubmit() {
    console.log('submitting: ' + this.user.username + '-' + this.user.password);
    this._userService.login(this.user).subscribe(
      data => this.onLoginSuccess(data),
      error => this.handleError(error)
    )
  }

  private handleError(error: any) {
    console.log(error);
  }

  private onLoginSuccess(data) {
    console.log(data);
    document.cookie = "JSESSIONID=" + data.JSESSIONID;
    this._authService.login(data.JSESSIONID);
    console.log('saved data, auth token: ' + this._authService.getToken());
    this._router.navigate(['/home']);
  }

}
