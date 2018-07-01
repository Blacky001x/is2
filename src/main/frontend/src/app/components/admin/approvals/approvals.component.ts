import { Component, OnInit } from '@angular/core';
import {FactsService} from "../../../services/facts.service";
import {Fact} from "../../../model/fact.model";

@Component({
  selector: 'app-approvals',
  templateUrl: './approvals.component.html',
  styleUrls: ['./approvals.component.css']
})
export class ApprovalsComponent implements OnInit {

  unapprovedFacts: Fact[];

  constructor(private _factsService: FactsService) { }

  ngOnInit() {
    this._factsService.getAllUnapprovedFacts().subscribe(
      data => this.unapprovedFacts = data
    )
  }

}
