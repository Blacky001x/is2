import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {FactsComponent} from "./components/facts/facts.component";
import {AddFactComponent} from "./components/facts/add-fact/add-fact.component";
import {AdminComponent} from "./components/admin/admin.component";
import {ApprovalsComponent} from "./components/admin/approvals/approvals.component";


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'admin', component: AdminComponent, children: [
      {path: 'approvals', component: ApprovalsComponent}
    ]},
  { path: 'home', component: HomeComponent, children: [
      {path: '', component: FactsComponent},
      {path: 'new', component: AddFactComponent}
    ] }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {



}
