import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {RegisterVO} from  '../dto/RegisterVO';
import {PostCmtVo} from '../dto/PostCmtVo';
import { ResultVo } from  '../Util/ResultVo';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
private url:string='http://localhost:8080/user';
private postUrl:string='http://localhost:8081/post';
  constructor(private http: HttpClient) { }

  createUser( reg:any){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'multipart/form-data',
      })
    };
   return  this.http.post(this.url+"/register",reg);
    

  }
  loginUser( reg:any) :Observable<ResultVo>{
   return  this.http.post<ResultVo>(this.url+"/login",reg);
  }
  geCategories(){

    return  this.http.get(this.postUrl+"/get-categories");
  }
  sendPost(postData:any){
    return  this.http.post(this.postUrl+"/add-post",postData);
 }
 getAllPosts():Observable<PostCmtVo[]>{
   return this.http.get<PostCmtVo[]>(this.postUrl+"/get-all-posts");
 }
 getPosts(postId:number){
  return this.http.get(this.postUrl+"/get-post/"+postId);
}
addLike(type:string,id:number){
  return this.http.get(this.postUrl+"/add-like/1"+"/"+type+"/"+id);

}
addComment(commentData){
  return  this.http.post(this.postUrl+"/add-comment",commentData);

}
}
