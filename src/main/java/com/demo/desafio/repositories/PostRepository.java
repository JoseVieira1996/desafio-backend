package com.demo.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.desafio.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	

}
