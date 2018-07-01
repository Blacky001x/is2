import { Component, OnInit } from '@angular/core';
import {FactsService} from "../../services/facts.service";
import {Fact} from "../../model/fact.model";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-facts',
  templateUrl: './facts.component.html',
  styleUrls: ['./facts.component.css']
})
export class FactsComponent implements OnInit {

  fact: Fact;

  constructor(private _factService: FactsService, private _router: Router, private _authService: AuthService) { }

  ngOnInit() {
    this._factService.nextRandom().subscribe(
      data => this.fact = data
    )
  }

  next() {
    this._factService.nextRandom().subscribe(
      data => this.fact = data
    )
  }

  submitNew() {
    this._router.navigate(['/home/new']);
  }

  isAuthenticated() {
    return this._authService.isAuthenticated();
  }

}
