package com.post.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.post.model.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

}
