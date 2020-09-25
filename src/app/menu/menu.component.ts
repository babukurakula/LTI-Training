import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  public userCreated : string;
  
  constructor(public auth : AuthenticationService) { }


  ngOnInit(): void {
  }

}
