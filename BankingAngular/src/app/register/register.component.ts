import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  register:Register;
  public status:string = "";
  constructor(private objHttp:HttpClient) { }

  ngOnInit() {
     this.register=new Register();
  }
  postData(){
    console.log(this.register);
    this.objHttp.post("http://localhost:8074/web/register",this.register)
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
class Register{
    username:string;
    phoneno:string;
    dob:string;
    address:string;
    aadhar:number;
    password:string;
    email:string;
}
