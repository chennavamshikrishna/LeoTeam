import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { RoutingModule } from './routing.module';
import { TransactionComponent } from './transaction/transaction.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddmoneyComponent } from './addmoney/addmoney.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MatTableModule } from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import { MainComponent } from './main/main.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MinistatementComponent } from './ministatement/ministatement.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    TransactionComponent,
    DashboardComponent,
    AddmoneyComponent,
    NavbarComponent,
    MainComponent,
    HeaderComponent,
    FooterComponent,
    MinistatementComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RoutingModule,
    MatTableModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
