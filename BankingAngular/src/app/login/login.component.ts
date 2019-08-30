import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DatabaseService} from '../database.service';
import {Router} from '@angular/router';
import {AuthserviceService} from '../authservice.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public accno:string;
  public password:string;
  public status;
  title:string="login page"
  failure:string;

  constructor(private dbservice:DatabaseService,private router:Router,public authService: AuthserviceService) { }

  ngOnInit() {
    if(localStorage.getItem("isLoggedIn")=="true" )
    {

        this.router.navigate(['/dashboard']);
    }


    }





  postLogin(accno, password) {
   this.dbservice.postCall(accno.trim(), password).then( data => {
       // console.log("POST Request is successful ", data);
       this.status = data;
       console.log("POST Request is successful ", this.status);
       this.setDetails(this.status)
     },
     error => {
       console.log("Error", error);
       this.status = "Error";
       this.setDetails(status)
     }
   );

  }
  setDetails(status: any) {
       if(status==true){
          this.authService.LogTheCustomerOrBanker(this.accno);
           this.dbservice.accno=this.accno;
           this.dbservice.isLoggedIn=true;
           this.router.navigate(["/dashboard"]);
       }
       else{
         this.failure="Invalid credentials"
         this.dbservice.isLoggedIn=false;
         console.log(this.failure);

       }
  }


}
