import { Component, OnInit } from '@angular/core';
import {StupidService} from "../../services/stupid.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private stupidService: StupidService) { }

  ngOnInit() {
  }

  m1() {
    this.stupidService.m1().subscribe(
      data => console.log(JSON.stringify(data))
    );
  }

  m2() {
    this.stupidService.m2().subscribe(
      data => console.log(JSON.stringify(data))
    );
  }

  m3() {
    this.stupidService.m3().subscribe();
  }

  test() {
    this.stupidService.m4().subscribe();
  }

}
