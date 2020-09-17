import { AstMemoryEfficientTransformer } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-view-posts',
  templateUrl: './view-posts.component.html',
  styleUrls: ['./view-posts.component.scss']
})
export class ViewPostsComponent implements OnInit {

  constructor(private regService :RegisterService) { }
  public posts :any;
  public postView : any;

  getAllPosts(){
    this.regService.getAllPosts().subscribe(
      (sucessData) =>{
        this.posts = sucessData;
        console.log(" post sucess "+ this.posts);

      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  getPost(postId:number){
    this.regService.getPosts(postId).subscribe(
      (sucessData) =>{
        this.postView = sucessData;
        console.log(" post sucess "+ this.posts);

      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  addLike(type:string,id:number){
    this.regService.addLike(type,id).subscribe(
      (sucessData) =>{
        console.log(" post sucess "+ this.posts);
        this.getPost(2);
      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  addComment(commentVall){
    commentVall['postId']=2;
    this.regService.addComment(commentVall).subscribe(
      (sucessData) =>{
        console.log(" post sucess "+ this.posts);
        this.getAllPosts();
        this.getPost(2);
      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  ngOnInit(): void {
    this.getAllPosts();
    this.getPost(2);
  }

}
