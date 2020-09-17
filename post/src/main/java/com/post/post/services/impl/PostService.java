package com.post.post.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.post.post.dto.CategoryVo;
import com.post.post.dto.PostCmtVo;
import com.post.post.dto.PostDto;
import com.post.post.dto.ResultVO;
import com.post.post.model.Category;
import com.post.post.model.Comments;
import com.post.post.model.Likes;
import com.post.post.model.Post;
import com.post.post.repository.CategoryRepository;
import com.post.post.repository.CommentsRepository;
import com.post.post.repository.LikesRepository;
import com.post.post.repository.PostRepository;
import com.post.services.IPostService;

@Service
public class PostService implements IPostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private CommentsRepository commentsRepo;
	@Autowired
	private LikesRepository likesRepo;
	
	
	public List<CategoryVo> getCategories() {
		List<Category> findAll = categoryRepo.findAll();
		List<CategoryVo> collect = findAll.stream().map(vo -> new CategoryVo(vo.getCategoryId(),vo.getCategory()) ).collect(Collectors.toList());
		return collect;
	}
	
	public ResultVO savePost(PostDto postVo) {
		Post post = new Post();
		post.setCategoryId(postVo.getCategoryId());
		post.setTag(postVo.getTag());
		post.setPost(postVo.getPost());
		post.setInsertedBy(postVo.getUserId());
		post.setInsertedTime(LocalDateTime.now());
		
		postRepo.save(post);
		ResultVO vo = new ResultVO();
		vo.setMessage("Post added");
		vo.setStatus(HttpStatus.OK.value());
		
		return vo;
		
	}	 
	
	public List<PostCmtVo> getAllPosts(){
		
		List<PostCmtVo> posts = postRepo.find(1L);
		/*List<Post> allPosts = postRepo.findAll();
		List<PostDto> posts = new ArrayList<PostDto>(allPosts.size());
		allPosts.forEach(vo -> {
			PostDto  v = new PostDto();
			v.setCategoryId(vo.getCategoryId());
			v.setPost(vo.getPost());
			v.setTag(vo.getTag());
			v.setPostId(vo.getPostId());
			v.setDate(vo.getInsertedTime().format(DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm")));
			posts.add(v);
			} );*/
		return posts;
	}

	@Override
	public ResultVO addComment(PostDto vo) {
		Comments comment = new Comments();
		comment.setPostId(vo.getPostId());
		comment.setComment(vo.getPost());
		comment.setTag(vo.getTag());
		comment.setInsertedBy(vo.getUserId());
		comment.setIsDeleted("N");
		comment.setInsertedTime(LocalDateTime.now());
		commentsRepo.save(comment);
		ResultVO retVo = new ResultVO("Comment Added",HttpStatus.OK.value());
		return retVo;
	}

	@Override
	public ResultVO addLike(Long userId,String type, Long id) {
		
		Likes like = new Likes();
		if(type != null && type.equalsIgnoreCase("comment"))	
			like.setCommentId(id);
		else		
			like.setPostId(id);

		like.setInsertedBy(userId);
		like.setIsDeleted("N");
		like.setInsertedTime(LocalDateTime.now());
		likesRepo.save(like);
		
		ResultVO retVo = new ResultVO("Comment Added",HttpStatus.OK.value());
		return retVo;
	}
	
	public PostDto getPost(Long postId){
		Post vo = postRepo.findById(postId).orElse(null);
		
		List<PostCmtVo> posts = postRepo.findPost(postId);
		
		
		PostDto  v = new PostDto();
		v.setCategoryId(vo.getCategoryId());
		v.setPost(vo.getPost());
		v.setTag(vo.getTag());
		v.setPostId(vo.getPostId());
		v.setPostCmtVos(posts);
		v.setPostLikes(postRepo.findpostLikecnt(postId));
		v.setDate(vo.getInsertedTime() != null ? vo.getInsertedTime().format(DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm")) : "");

		return v;
	}

}
