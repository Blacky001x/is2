import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../model/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  constructor(private _userService: UserService, private _router: Router) { }

  ngOnInit() {
    this.user = new User();
  }

  onSubmit() {
    console.log('edit register.component.ts');
    console.log(this.user);
    this._userService.register(this.user).subscribe(
      newuser => {
          this.user = new User();
          this._router.navigate(['/login'])
        }, error => console.log(error)
    )
  }

}
