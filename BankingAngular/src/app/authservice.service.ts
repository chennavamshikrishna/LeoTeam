import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  constructor() { }
  LogTheCustomerOrBanker(accno:string)
  {
    localStorage.setItem('isLoggedIn', "true");
    localStorage.setItem('accno',accno);

  }
}
