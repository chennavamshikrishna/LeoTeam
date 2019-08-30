import { Component, OnInit } from '@angular/core';
import {DatabaseService} from '../database.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-addmoney',
  templateUrl: './addmoney.component.html',
  styleUrls: ['./addmoney.component.css']
})
export class AddmoneyComponent implements OnInit {
  amount;
  status:string;
  balance:string;

  constructor(private dbservice:DatabaseService,private objHttp:HttpClient){

  }

  ngOnInit() {




  }
  addMoney(){
    this.dbservice.postDeposit(this.amount,this.dbservice.accno).then(data => {
        // console.log("POST Request is successful ", data);
        this.status = data.toString();
        console.log("POST Request is successful ", this.status);

      }
      );

  }

}
