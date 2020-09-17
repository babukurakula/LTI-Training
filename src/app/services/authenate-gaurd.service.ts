import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenateGaurdService implements CanActivate{

  constructor(private auth: AuthenticationService) { }

  canActivate():boolean{
    return this.auth.isUserLoggedIn();
  }
}
