import {Injectable, Input, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';

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

}
