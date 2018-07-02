import { Component, OnInit } from '@angular/core';
import {FactsService} from "../../services/facts.service";
import {Fact} from "../../model/fact.model";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {Rating} from "../../model/rating.model";
import {RatingService} from "../../services/rating.service";

@Component({
  selector: 'app-facts',
  templateUrl: './facts.component.html',
  styleUrls: ['./facts.component.css']
})
export class FactsComponent implements OnInit {

  fact: Fact;
  rating: Rating;

  constructor(
    private _factService: FactsService,
    private _router: Router,
    private _authService: AuthService,
    private _ratingService: RatingService
  ) { }

  ngOnInit() {
    this.rating = new Rating();
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

  processRating() {
    this.rating.factId = this.fact.id;
    console.log('rating: ');
    console.log(this.rating);
    this._ratingService.postRating(this.rating).subscribe(data => { alert('Saved!') });
  }

  setRating(number: number) {
    this.rating.rating = number;
  }
}
