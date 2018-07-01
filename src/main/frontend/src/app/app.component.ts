import { Component } from '@angular/core';
import {AuthService} from "./services/auth.service";
import {UserService} from "./services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private _authService: AuthService, private _userService: UserService) { }

  logout() {

  }

  isAuthenticated() {
    return this._authService.isAuthenticated();
  }

  onLogout() {
    console.log('logout requested!')
    this._authService.logout(); // za svaki slucaj!
    this._userService.logout().subscribe(
      data => this._authService.logout()
    )
  }

  cookie() {
    console.log('Hey, my cookies is: ' + document.cookie);
  }
}
