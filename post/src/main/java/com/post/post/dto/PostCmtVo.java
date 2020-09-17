package com.post.post.dto;

import java.time.LocalDateTime;

public class PostCmtVo {
	
	private Long postId;
	private String category;
	private String tag;
	private String post;
	private Long userId;
	private LocalDateTime date;
	private String comment;
	private Long commentId;
	private Long likes;
	private Long noOfCmts;
	private Long cmtLikes;
		
	
	public PostCmtVo(Long postId, String category, String tag, String post, Long userId, LocalDateTime date, String comment,
			Long commentId, Long likes,Long noOfCmts) {
		super();
		this.postId = postId;
		this.category = category;
		this.tag = tag;
		this.post = post;
		this.userId = userId;
		this.date = date;
		this.comment = comment;
		this.commentId = commentId;
		this.likes = likes;
		this.noOfCmts = noOfCmts;
	}
	public PostCmtVo(Long postId, String category, String tag, String post, Long userId, LocalDateTime date, String comment,
			Long commentId, Long likes,Long noOfCmts,Long cmtLikes) {
		super();
		this.postId = postId;
		this.category = category;
		this.tag = tag;
		this.post = post;
		this.userId = userId;
		this.date = date;
		this.comment = comment;
		this.commentId = commentId;
		this.likes = likes;
		this.noOfCmts = noOfCmts;
		this.cmtLikes = cmtLikes;
	}
	public PostCmtVo(Long postId, String comment,
			Long commentId, Long likes,Long cmtLikes,String tag) {
		this.postId = postId;
		this.comment = comment;
		this.commentId = commentId;
		this.likes = likes;
		this.cmtLikes = cmtLikes;
		this.tag = tag;

	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getCmtLikes() {
		return cmtLikes;
	}
	public void setCmtLikes(Long cmtLikes) {
		this.cmtLikes = cmtLikes;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public Long getNoOfCmts() {
		return noOfCmts;
	}
	public void setNoOfCmts(Long noOfCmts) {
		this.noOfCmts = noOfCmts;
	}

	
	

}
