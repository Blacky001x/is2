import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Fact} from "../model/fact.model";
import {Category} from "../model/category.model";

@Injectable()
export class FactsService {

  private baseUrl = 'http://localhost:8080';
  private nextRandomUrl = this.baseUrl + '/facts/next';
  private getAllCategoriesUrl = this.baseUrl + '/facts/categories';
  private postNewFactUrl = this.baseUrl + '/facts/';
  private getAllUnapprovedUrl = this.baseUrl + '/admin/facts/unapproved';
  private postUnapprovedChangesUrl = this.baseUrl + '/admin/facts/unapproved';

  constructor(private _http: HttpClient) { }

  nextRandom() {
    return this._http.get<Fact>(this.nextRandomUrl);
  }

  getAllCategories() {
    return this._http.get<Category[]>(this.getAllCategoriesUrl);
  }

  postFact(fact: Fact) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this._http.post<Fact>(this.postNewFactUrl, fact, {headers,  withCredentials:true });
  }

  getAllUnapprovedFacts() {
    return this._http.get<Fact[]>(this.getAllUnapprovedUrl, {withCredentials: true});
  }

  postUpdateFacts(facts: Fact[]) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this._http.post<Fact>(this.postUnapprovedChangesUrl, facts, {headers,  withCredentials:true });
  }
}
