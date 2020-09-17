import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/register.service';
import {RegisterVO} from  '../dto/RegisterVO';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent  {

  //public regObj : RegisterVO;
  public  file:File;
  public regObj ={
       userName:'' ,
        firstName:'',
        lastName:'',
        password:'',
         mobileNo:'',
        
  }

  constructor(private regService:RegisterService) { }



  onFileChange(event){
    console.log(event.target.files);
     this.file = <File> event.target.files[0];
  }
  createUser(formValues){
    console.log(this.regObj)
    let data = new FormData();
    
      for(let i in formValues){
        data.append(i,formValues[i]);

      }
    data.append('file',this.file,this.file.name);
    // data.append('userName',this.regObj.userName);
    // data.append('firstName',this.regObj.firstName);
    // data.append('lastName',this.regObj.lastName);
    // data.append('password',this.regObj.password);
    // data.append('mobileNo',this.regObj.mobileNo);
    this.regService.createUser(data).subscribe(
      (successData)=>{
        console.log(successData)
      },
      (errorData)=>{
        console.log(errorData)
      }
    )
  }
 
}
