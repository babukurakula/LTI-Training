import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.scss']
})
export class AddPostComponent implements OnInit {

  constructor(private regServes :RegisterService) { }
   public categories : any;
  
   sendPost(postData){
      console.log("sendPost : "+ postData)
      this.regServes.sendPost(postData).subscribe(
        (sucessData) =>{
          this.categories = sucessData;
          console.log(" post sucess "+ this.categories);
  
        },
        (errorData) =>{
          console.log("post errorData : "+errorData);
        }
      )
   }
  ngOnInit(): void {
    this.regServes.geCategories().subscribe(
      (sucessData) =>{
        this.categories = sucessData;
        console.log(" this.categories "+ this.categories);

      },
      (errorData) =>{
        console.log("errorData : "+errorData);
      }
    )
  }

}
