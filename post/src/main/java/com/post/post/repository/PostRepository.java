package com.post.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.post.post.dto.PostCmtVo;
import com.post.post.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	//@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			//+ "FROM Department d INNER JOIN d.employees e")
	//PostCmtVo(Long postId, String category, String tag, String post, Long userId, 
	//String date, String comment,
		//	Long commentId, Long likeIds)
	
	@Query(" SELECT new  com.post.post.dto.PostCmtVo(post.postId,"
			+ "post.category.category ,"
			+ "post.tag,"
			+ "post.post,"
			+ "post.insertedBy,"
			+ "post.insertedTime,"
			+ "c.comment,"
			+ "c.commentId,"
			+ "count(l.postId),"
			+ "count(c.postId)) FROM com.post.post.model.Likes l  "
			+ "right  join com.post.post.model.Post post on post.postId = l.postId  "
			+ "left join  com.post.post.model.Comments c on c.postId = l.postId "
			+ " group by post.postId ")
	public List<PostCmtVo> find(@Param("postId") Long  postId);
	
	@Query(" SELECT new  com.post.post.dto.PostCmtVo(0L,"
			+ "c.comment,"
			+ "c.commentId,"
			+ "count(l.postId),"
			+ "count(l.commentId),"
			+ "c.tag) "
			+ " FROM com.post.post.model.Likes l  "
			+ "right join  com.post.post.model.Comments c on c.commentId = l.commentId  "
			+ "where c.postId=:postId or l.postId= :postId "
			+ " group by  c.commentId ")
	public List<PostCmtVo> findPost(@Param("postId") Long  postId);
	
	@Query(" SELECT count(l.postId) from Likes l where l.postId=:postId")
	public Long findpostLikecnt(@Param("postId") Long  postId);
}
