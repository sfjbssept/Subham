import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  isUserLoggedIn:boolean;
  username:any;

  constructor() {
    this.isUserLoggedIn = false;

   }
   setUserLoggedIn(){
    this.isUserLoggedIn=true;
   }
   getUserLoggedIn(){
    return this.isUserLoggedIn;
   }
}
