import { Component, OnInit } from '@angular/core';
import {FactsService} from "../../../services/facts.service";
import {Fact} from "../../../model/fact.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-approvals',
  templateUrl: './approvals.component.html',
  styleUrls: ['./approvals.component.css']
})
export class ApprovalsComponent implements OnInit {

  unapprovedFacts: Fact[];

  constructor(private _factsService: FactsService, private _router: Router) { }

  ngOnInit() {
    this._factsService.getAllUnapprovedFacts().subscribe(
      data => this.unapprovedFacts = data
    )
  }

  onSubmit() {
    console.log(JSON.stringify(this.unapprovedFacts));
    this._factsService.postUpdateFacts(this.unapprovedFacts).subscribe(
      data => this._router.navigate(['/home'])
    );
  }

}
