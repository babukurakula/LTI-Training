package com.post.post.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private Long postId;
	private Integer categoryId;
	private String tag;
	private String post;
	private Long userId;
	private String date;
	private Long postLikes;
	
	List<PostCmtVo> postCmtVos;
	
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<PostCmtVo> getPostCmtVos() {
		return postCmtVos;
	}
	public void setPostCmtVos(List<PostCmtVo> postCmtVos) {
		this.postCmtVos = postCmtVos;
	}
	public Long getPostLikes() {
		return postLikes;
	}
	public void setPostLikes(Long postLikes) {
		this.postLikes = postLikes;
	}
	
	
	
}
