import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  isUserLoggedIn(): boolean{
    let user = sessionStorage.getItem("user");
    if(user == null){
      return false;
    }else{
      return true;
    }
  }
  
  // getUSerType
  // getUSerNAme
  // getUserDEtail
  
  // logout 
  logout(){
    sessionStorage.removeItem("user");
    sessionStorage.clear()
  }  
  
}
