import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DatabaseService} from '../database.service';




@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {


  public details:string;
  public balance:string;
  status:string;

  public notify:string;
  constructor(private objHttp: HttpClient,private database:DatabaseService) { }

  ngOnInit() {


   this.database.fetchProfile().then(
     data => {
       this.details=JSON.stringify(data);
       this.details=JSON.parse(this.details);
      // console.log("POST Request is successful ", this.details[0].aadhar);

       this.status = "POST Request is successful";
     },
     error => {
       console.log("Error", error);
       this.status = "Error";
     }
   );
    this.objHttp.post("http://localhost:8074/web/minimumbalance",
      {
        "accno": this.database.accno

      })
      .subscribe(
        data => {
          this.balance=JSON.stringify(data);
          this.balance=JSON.parse(this.balance);
          console.log("POST Request is successful ", data[0].amount);
          if(data[0].amount<5000){
              console.log("please add amount to your account");
              this.notify="Your Balance is Below 5000 please Maintain Minimum Balance";
          }
          else{
            this.notify="";
          }

          this.status = "POST Request is successful";
        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );






  }




    /*this.database.fetchProfile().subscribe(
      data => {
        this.details=JSON.stringify(data);
        console.log("POST Request is successful ", this.details);

        this.status = "POST Request is successful";
        console.log(this.details.username);
      },
      error => {
        console.log("Error", error);
        this.status = "Error";
      }
    );*/

    /*this.objHttp.post("http://localhost:8074/web/profile",
      {
        "accno": "DBS88233F"

      })
      .subscribe(
        data => {
          this.details=JSON.stringify(data);
          console.log("POST Request is successful ", this.details);
          this.details=data;
          this.status = "POST Request is successful";
        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );*/



  }



