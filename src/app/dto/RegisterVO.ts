import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class RegisterVO{

      public   userName:string ;
      public  firstName:string ;
      public  lastName:string ;
      public  password:string ;
      public   mobileNo:string ;
      public   file:any;
}