package com.post.post.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	
	@Id
	@Column(name="post_id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name="category_id" )
	private Integer categoryId;
	
	@Column(name="tag" )
	private String tag;
	
	@Column(name="post" )
	private String post;
	
	@Column(name="inserted_By" )
	private Long insertedBy;
	
	@Column(name="inserted_time" )
	private LocalDateTime insertedTime;
	
	@Column(name="updated_time" )
	private LocalDateTime updatedTime;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name ="category_id",updatable = false,insertable = false)
	private Category category;

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

	public Long getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(Long insertedBy) {
		this.insertedBy = insertedBy;
	}

	public LocalDateTime getInsertedTime() {
		return insertedTime;
	}

	public void setInsertedTime(LocalDateTime insertedTime) {
		this.insertedTime = insertedTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
