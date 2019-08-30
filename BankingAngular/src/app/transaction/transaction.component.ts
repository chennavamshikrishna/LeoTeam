import { Component, OnInit } from '@angular/core';
import {DatabaseService} from '../database.service';
import {formatDate} from '@angular/common';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  tra:Transaction;
  status:string;
  balance:string;
  negative:string;


  constructor(private database:DatabaseService,private objHttp:HttpClient) { }

  ngOnInit() {
    this.tra=new Transaction(localStorage.getItem("accno"));

  }
  checkBalance(){
    this.objHttp.post("http://localhost:8074/web/checkbalance",
      {
        "accno": localStorage.getItem("accno"),
        "amount":this.tra.amount

      })
      .subscribe(
        data => {
          console.log(data);
          if(data==true){
             this.postTransfer();
             this.balance="";
          }
          else{
            this.balance = "you dont have minimum balance to perform the transaction";

          }

        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );

  }
  postTransfer(){



    this.tra.acc1no=this.tra.acc1no.trim();
    if(this.tra.amount<0){
      this.negative="amount cannot be negative";

    }
      if(this.tra.amount>10000){
          this.tra.flag=1;
      }
      else{
        this.tra.flag=0;
      }
    this.objHttp.post("http://localhost:8074/web/transaction",this.tra)
      .toPromise()
      .then(
        data => {
          console.log("POST Request is successful ", data);
          this.status = "POST Request is successful";
        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );

  }

}
class Transaction{
        acc1no:string;
        acc2no:string;
        amount;
        tdate:any;
        ttype:number;
        flag:number;

  constructor(accno: string){
          this.ttype=1;
          this.acc2no=accno;

          this.tdate= formatDate(new Date(), 'yyyy-MM-dd', 'en')
        }

}
