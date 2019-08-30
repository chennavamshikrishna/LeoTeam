import {Injectable, Input, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
interface Profile {
  username:string;
  phoneno:string;
  dob;
  aadhar
  email:string
  password:string;
  accno:string
}
@Injectable({
  providedIn: 'root'
})
export class DatabaseService {
  @Input() status:string;
  public accno:string;
  public isLoggedIn:boolean;

  constructor(private objHttp:HttpClient) { }
  postCall(accno, password){
    return this.objHttp.post("http://localhost:8074/web/login",
      {
        "accno": accno,
        "password": password,
      })
      .toPromise()

  }
  postDeposit(amount,accno){
    return this.objHttp.post("http://localhost:8074/web/deposit",
      {
        "accno": accno,
        "amount":amount,
      })
      .toPromise()

  }
  fetchProfile(){
    return this.objHttp.post("http://localhost:8074/web/profile",
      {
        "accno": localStorage.getItem("accno")

      })
      .toPromise()

  }

}
