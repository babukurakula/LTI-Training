import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MenuComponent } from './menu/menu.component';
import { AddPostComponent } from './add-post/add-post.component';
import { ViewPostsComponent } from './view-posts/view-posts.component';
import {AuthenateGaurdService} from './services/authenate-gaurd.service';

const routes: Routes = [
  {path : "", redirectTo: "login", pathMatch : "full"},

  {
    path:"login",component:LoginComponent
  },
  {
    path:"register",component:RegisterComponent,canActivate:[AuthenateGaurdService]
  },
  {
    path:"menu",component:MenuComponent ,canActivate:[AuthenateGaurdService]
  },
  {
    path: 'post' ,component:AddPostComponent,canActivate:[AuthenateGaurdService]
  },
  {
    path:'view-posts' ,component:ViewPostsComponent,canActivate:[AuthenateGaurdService]
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
