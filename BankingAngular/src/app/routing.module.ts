import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from './dashboard/dashboard.component';
import {AddmoneyComponent} from './addmoney/addmoney.component';
import {TransactionComponent} from './transaction/transaction.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {MinistatementComponent} from './ministatement/ministatement.component';
import {AuthguardService} from './authguard.service';
export const router: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {
    path:'login',component:LoginComponent
  },
  {
    path:'home',component:DashboardComponent
  },
  {
    path:'dashboard',component:DashboardComponent
  },
  {
    path:'addmoney',component:AddmoneyComponent
  },
  {
    path:'transactions',component:TransactionComponent
  },
  {
    path:'register',component:RegisterComponent
  },
  {
    path:'ministatement',component:MinistatementComponent
  }

];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(router)
  ],
  exports: [RouterModule]

})
export class RoutingModule { }
