package com.post.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.post.post.dto.CategoryVo;
import com.post.post.dto.PostCmtVo;
import com.post.post.dto.PostDto;
import com.post.post.dto.ResultVO;
import com.post.services.IPostService;



@Controller
@RequestMapping("/post")
@CrossOrigin
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	@RequestMapping(value = "/add-post",  consumes =MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResultVO> savePost(@RequestBody PostDto postVo){
		ResultVO vo = this.postService.savePost(postVo);
		ResponseEntity<ResultVO> response = new ResponseEntity<ResultVO>(vo,HttpStatus.OK);
		return response;
	}
	@GetMapping("/get-categories")
	public ResponseEntity<List<CategoryVo>> getCategories() {
		List<CategoryVo> categories = this.postService.getCategories();
		return new ResponseEntity<List<CategoryVo>>(categories,HttpStatus.OK);
	}
	@GetMapping("/get-all-posts")
	public ResponseEntity<List<PostCmtVo>> getAllPosts() {
		List<PostCmtVo> posts = this.postService.getAllPosts();
		return new ResponseEntity<List<PostCmtVo>>(posts,HttpStatus.OK);
	}
	@GetMapping("/get-post/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable("postId") Long postId){
		PostDto posts = this.postService.getPost(postId);
		return new ResponseEntity<PostDto>(posts,HttpStatus.OK);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResultVO> handleException(Exception ex) {
		ResultVO vo = new ResultVO();
		vo.setMessage(ex.getMessage());
		vo.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return  new ResponseEntity<ResultVO>(vo,HttpStatus.NOT_ACCEPTABLE);

	}
	@RequestMapping(value = "/add-comment",  consumes =MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResultVO> addComment(@RequestBody PostDto postVo){
		ResultVO vo = this.postService.addComment(postVo);
		ResponseEntity<ResultVO> response = new ResponseEntity<ResultVO>(vo,HttpStatus.OK);
		return response;
	}	
	@RequestMapping(value = "/add-like/{userId}/{type}/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResultVO> addLike(@PathVariable Long userId ,@PathVariable String type,@PathVariable Long id){
		ResultVO vo = this.postService.addLike(userId , type, id);
		ResponseEntity<ResultVO> response = new ResponseEntity<ResultVO>(vo,HttpStatus.OK);
		return response;
	}
}
