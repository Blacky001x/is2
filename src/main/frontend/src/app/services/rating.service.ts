import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Rating} from "../model/rating.model";
import {Fact} from "../model/fact.model";

@Injectable()
export class RatingService {

  private baseUrl = 'http://localhost:8080';
  private postRatingUrl = this.baseUrl + '/rating/';

  constructor(private _http: HttpClient) { }

  postRating(rating: Rating) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this._http.post<Fact>(this.postRatingUrl, rating, {headers,  withCredentials:true });
  }

}
