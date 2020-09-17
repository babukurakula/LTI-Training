package com.post.post.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="like_id",nullable = false,updatable = false)
	private Long likeId;
	
	@Column(name="post_id")
	private Long postId;
	
	@Column(name="is_deleted")
	private String isDeleted;
	
	@Column(name="inserted_time")
	private LocalDateTime insertedTime;
	
	@Column(name="inserted_by")
	private Long insertedBy;
	
	@Column(name="comment_id")
	private Long commentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id" ,insertable = false,updatable = false)
	private Comments comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id" ,insertable = false,updatable = false)
	private Post post;
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public LocalDateTime getInsertedTime() {
		return insertedTime;
	}
	public void setInsertedTime(LocalDateTime insertedTime) {
		this.insertedTime = insertedTime;
	}
	public Long getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(Long insertedBy) {
		this.insertedBy = insertedBy;
	}
	public Long getLikeId() {
		return likeId;
	}
	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
	

}
