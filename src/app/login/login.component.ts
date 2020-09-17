import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/register.service';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private  regService : RegisterService ,private route : Router) { }

  private form : FormGroup;
  ngOnInit(): void {
  }
  loginUser(looginData){
    sessionStorage.clear();
    this.regService.loginUser(looginData).subscribe(
      (succuessData)=> {
        sessionStorage.setItem("user","userCreated");
        sessionStorage.setItem("userData",JSON.stringify(succuessData.user));
        this.route.navigate(['/post']);
      }
    ),
    (errorData) => {

    }
  }

}
