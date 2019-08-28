import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DatabaseService} from '../database.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public accno:string;
  public password:string;
  public status;

  constructor(private dbservice:DatabaseService) { }

  ngOnInit() {

  }


  postLogin(accno, password) {
   this.dbservice.postCall(accno, password).then( data => {
       // console.log("POST Request is successful ", data);
       this.status = data;
       console.log("POST Request is successful ", this.status);
       this.setDetails(this.status)
     },
     error => {
       console.log("Error", error);
       this.status = "Error";
     }
   );

  }
  setDetails(status: any) {
       if(status==true){
           this.dbservice.accno=this.accno;
           this.dbservice.isLoggedIn=true;
       }
       else{
         this.dbservice.isLoggedIn=false;
       }
       console.log(this.dbservice.accno);
  }


}
