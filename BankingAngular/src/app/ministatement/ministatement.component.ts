import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DatabaseService} from '../database.service';
import {AuthserviceService} from '../authservice.service';

@Component({
  selector: 'app-ministatement',
  templateUrl: './ministatement.component.html',
  styleUrls: ['./ministatement.component.css']
})
export class MinistatementComponent implements OnInit {

  creditdetails;
  status:string;
  debitdetails;
  constructor(private objHttp:HttpClient,private database:DatabaseService,private authservice:AuthserviceService) { }

  ngOnInit() {
    this.objHttp.post("http://localhost:8074/web/creditstatement",
      {
        "acc1no":localStorage.getItem("accno")

      })
      .subscribe(
        data => {
          this.creditdetails=data;
          console.log("POST Request is successful ", this.creditdetails[0].amount);
          this.status = "POST Request is successful";
        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );
    this.objHttp.post("http://localhost:8074/web/debitstatement",
      {
        "acc2no": localStorage.getItem("accno")

      })
      .subscribe(
        data => {
          this.debitdetails=data;
          console.log("POST Request is successful ", this.debitdetails[0].amount);
          this.status = "POST Request is successful";
        },
        error => {
          console.log("Error", error);
          this.status = "Error";
        }
      );


  }



  createPDF() {
    var sTable = document.getElementById('transID').innerHTML;

    var style = "<style>";
    style = style + "table {width: 100%;font: 17px Calibri;}";
    style = style + "table, thead,tbody,th,tr, td {border: solid 1px #DDD; border-collapse: collapse;";
    style = style + "padding: 2px 3px;text-align: center;}";
    style = style + "</style>";

    var win = window.open('', '', 'height=700,width=700');

    win.document.write('<title>Your Transaction History</title>');
    win.document.write(style);
    win.document.write('</head>');
    win.document.write(' <div class="container"> ');
    win.document.write(' <table class= "table table-striped"');
    win.document.write(sTable);
    win.document.close();
    win.print();
  }

}
