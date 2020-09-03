import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent  {

  constructor(regService:RegisterService) { }


  public regObj= {
    userName:'',
    firstName:'',
    lastName:'',
    password:'',
    mobileNo:'',
   file:''
  }
  onFileChange(event){
     this.regObj.file = event.target.files[0];
  }
  createUser(){
    
  }
 
}
