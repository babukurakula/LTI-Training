package com.post.services;

import java.util.List;

import com.post.post.dto.CategoryVo;
import com.post.post.dto.PostCmtVo;
import com.post.post.dto.PostDto;
import com.post.post.dto.ResultVO;

public interface IPostService {

	public ResultVO savePost(PostDto postVo);
	public List<CategoryVo> getCategories();
	public List<PostCmtVo> getAllPosts();
	public ResultVO addComment(PostDto vo);
	public ResultVO addLike(Long userId,String type ,Long id);
	public PostDto getPost(Long postId);
}
