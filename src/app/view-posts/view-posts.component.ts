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
  public activePostId : number;

  getAllPosts(){
    this.regService.getAllPosts().subscribe(
      (sucessData) =>{
        this.posts = sucessData;
        this.activePostId = sucessData[0].postId;
        this.getPost(sucessData[0].postId)
        console.log(" post sucess "+ this.posts);

      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  getPost(postId:number){
    this.activePostId = postId;
    this.regService.getPosts(this.activePostId).subscribe(
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
        this.getPost(this.activePostId);
      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  addComment(commentForm){
    let commentVall = commentForm.value;
    commentVall['postId']=this.activePostId;
    this.regService.addComment(commentVall).subscribe(
      (sucessData) =>{
        console.log(" post sucess "+ this.activePostId);
        //this.getAllPosts();
        this.getPost(this.activePostId);
        commentForm.reset();
      },
      (errorData) =>{
        console.log("post errorData : "+errorData);
      }
    )
  }
  ngOnInit(): void {
    this.getAllPosts();
  }

}
