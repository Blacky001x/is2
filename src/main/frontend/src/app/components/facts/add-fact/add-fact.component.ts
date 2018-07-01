import { Component, OnInit } from '@angular/core';
import {Fact} from "../../../model/fact.model";
import {Category} from "../../../model/category.model";
import {FactsService} from "../../../services/facts.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-fact',
  templateUrl: './add-fact.component.html',
  styleUrls: ['./add-fact.component.css']
})
export class AddFactComponent implements OnInit {

  fact: Fact;
  categories: Category[];

  constructor(private _factService: FactsService, private _router: Router) { }

  ngOnInit() {
    this.fact = new Fact();
    this._factService.getAllCategories().subscribe(
      data => {
        this.categories = data;
        this.fact.category = this.categories[0];
      }
    );
  }

  onSubmit() {
    console.log('submiting:');
    console.log(this.fact);
    this._factService.postFact(this.fact).subscribe(
      data => this._router.navigate(['/home'])
    )
  }


  print() {
    //console.log(this.fact);
    console.log(this.fact.category);
    //console.log('-------')
  }

}
