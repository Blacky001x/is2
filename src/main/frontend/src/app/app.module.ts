import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app.routing";
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {FormsModule} from "@angular/forms";
import {UserService} from "./services/user.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthService} from "./services/auth.service";
import {StupidService} from "./services/stupid.service";
import {AuthInterceptor} from "./services/auth.interceptor";
import { FactsComponent } from './components/facts/facts.component';
import {FactsService} from "./services/facts.service";
import { AddFactComponent } from './components/facts/add-fact/add-fact.component';
import { AdminComponent } from './components/admin/admin.component';
import { ApprovalsComponent } from './components/admin/approvals/approvals.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    FactsComponent,
    AddFactComponent,
    AdminComponent,
    ApprovalsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    UserService,
    FactsService,
    StupidService,
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: AuthInterceptor,
    //   multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
