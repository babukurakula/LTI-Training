import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MenuComponent } from './menu/menu.component';
import { AddPostComponent } from './add-post/add-post.component';
import { ViewPostsComponent } from './view-posts/view-posts.component';

const routes: Routes = [
  {path : "", redirectTo: "login", pathMatch : "full"},

  {
    path:"login",component:LoginComponent
  },
  {
    path:"register",component:RegisterComponent
  },
  {
    path:"menu",component:MenuComponent
  },
  {
    path: 'post' ,component:AddPostComponent
  },
  {
    path:'view-posts' ,component:ViewPostsComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
