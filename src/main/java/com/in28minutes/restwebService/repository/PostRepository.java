package com.in28minutes.restwebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restwebService.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
